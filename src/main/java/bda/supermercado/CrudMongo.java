package bda.supermercado;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.bson.Document;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CrudMongo {
    private static final String COLLECTION_NAME = "ventas";

    public void insertarVenta(LinkedList<Venta> items) {
        try (MongoClient mongoClient = ConnMongo.createMongoClient()) {
            MongoDatabase database = mongoClient.getDatabase(ConnMongo.getDatabaseName());

            MongoCollection<Document> ventasCollection = database.getCollection(COLLECTION_NAME);

            int proximoId = getProximoId(ventasCollection);

            Document ventaDocument = new Document();
            ventaDocument.append("_id", proximoId);

            String fechaAtual = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            ventaDocument.append("fecha", fechaAtual);
            String horaAtual = new SimpleDateFormat("HH:mm:ss").format(new Date());
            ventaDocument.append("hora", horaAtual);

            LinkedList<Document> productosVendidos = new LinkedList<>();

            double valorTotalVenta = 0.0;

            for (Venta item : items) {
                Document productoVendido = new Document()
                        .append("nombre", item.getNombre())
                        .append("cantidad", item.getCantidad())
                        .append("valorunitario", item.getValorUnitario())
                        .append("valortotal", item.getValorTotal());

                productosVendidos.add(productoVendido);

                valorTotalVenta += item.getValorTotal();
            }

            ventaDocument.append("productosVendidos", productosVendidos)
                    .append("valorTotalVenta", valorTotalVenta);

            ventasCollection.insertOne(ventaDocument);

        } catch (Exception e) {
            System.out.println("Error inserting sale into MongoDB: " + e.getMessage());
        }
    }

    private int getProximoId(MongoCollection<Document> collection) {
        Document maxIdDocument = collection.find().sort(new Document("_id", -1)).first();
        int proximoId = (maxIdDocument == null) ? 1 : maxIdDocument.getInteger("_id") + 1;

        return proximoId;
    }

    public void exportarVentasDia(String data) {
        try (MongoClient mongoClient = ConnMongo.createMongoClient()) {
            MongoDatabase database = mongoClient.getDatabase(ConnMongo.getDatabaseName());
            MongoCollection<Document> ventasCollection = database.getCollection(CrudMongo.COLLECTION_NAME);

            Document query = new Document("fecha", new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("dd/MM/yyyy").parse(data)));
            FindIterable<Document> result = ventasCollection.find(query);

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Ventas");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("fecha");
            headerRow.createCell(1).setCellValue("hora");
            headerRow.createCell(2).setCellValue("valorTotal");

            int rowNum = 1;
            for (Document document : result) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(document.getString("fecha"));
                row.createCell(1).setCellValue(document.getString("hora"));
                row.createCell(2).setCellValue(document.getDouble("valorTotalVenta"));
            }

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar Planilla Excel");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos Excel (*.xlsx)", "xlsx"));

            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                String caminhoArquivo = fileChooser.getSelectedFile().getAbsolutePath();
                if (!caminhoArquivo.toLowerCase().endsWith(".xlsx")) {
                    caminhoArquivo += ".xlsx";
                }

                try (FileOutputStream fileOut = new FileOutputStream(caminhoArquivo)) {
                    workbook.write(fileOut);
                }

                workbook.close();
                JOptionPane.showMessageDialog(null, "Exportación a Excel completa. Archivo: " + caminhoArquivo);
            } else {
                JOptionPane.showMessageDialog(null, "Exportación a Excel cancelada por el usuario.");
            }
        } catch (ParseException | IOException e) {
            JOptionPane.showMessageDialog(null, "Error al exportar a Excel: " + e.getMessage());
        }
    }

    public void exportarVentasMes(String data) {
        try (MongoClient mongoClient = ConnMongo.createMongoClient()) {
            MongoDatabase database = mongoClient.getDatabase(ConnMongo.getDatabaseName());
            MongoCollection<Document> ventasCollection = database.getCollection(CrudMongo.COLLECTION_NAME);

            Calendar inicioMes = Calendar.getInstance();
            inicioMes.setTime(new SimpleDateFormat("MM/yyyy").parse(data));
            inicioMes.set(Calendar.DAY_OF_MONTH, 1);
            Date dataInicioMes = inicioMes.getTime();

            Calendar fimMes = Calendar.getInstance();
            fimMes.setTime(new SimpleDateFormat("MM/yyyy").parse(data));
            fimMes.set(Calendar.DAY_OF_MONTH, fimMes.getActualMaximum(Calendar.DAY_OF_MONTH));
            Date dataFimMes = fimMes.getTime();

            Document query = new Document("fecha",
                    new Document("$gte", new SimpleDateFormat("yyyy-MM-dd").format(dataInicioMes))
                            .append("$lte", new SimpleDateFormat("yyyy-MM-dd").format(dataFimMes)));

            FindIterable<Document> result = ventasCollection.find(query);

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Ventas");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("fecha");
            headerRow.createCell(1).setCellValue("hora");
            headerRow.createCell(2).setCellValue("valorTotal");

            int rowNum = 1;
            for (Document document : result) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(document.getString("fecha"));
                row.createCell(1).setCellValue(document.getString("hora"));
                row.createCell(2).setCellValue(document.getDouble("valorTotalVenta"));
            }

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar Planilla Excel");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos Excel (*.xlsx)", "xlsx"));

            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                String caminhoArquivo = fileChooser.getSelectedFile().getAbsolutePath();
                if (!caminhoArquivo.toLowerCase().endsWith(".xlsx")) {
                    caminhoArquivo += ".xlsx";
                }

                try (FileOutputStream fileOut = new FileOutputStream(caminhoArquivo)) {
                    workbook.write(fileOut);
                }

                workbook.close();
                JOptionPane.showMessageDialog(null, "Exportación a Excel completa. Archivo: " + caminhoArquivo);

            } else {
                JOptionPane.showMessageDialog(null, "Exportación a Excel cancelada por el usuario.");
            }
        } catch (ParseException | IOException e) {
            JOptionPane.showMessageDialog(null, "Error al exportar a Excel: " + e.getMessage());
        }
    }



    
}

   

