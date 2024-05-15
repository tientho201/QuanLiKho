package com.quanlikho.controller;



import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.TabSettings;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.quanlikho.BUS.*;
import com.quanlikho.DTO.*;
import com.quanlikho.DAO.*;

/**
 *
 * @author Tran Nhat Sinh
 */
public class WritePDF {

    DecimalFormat formatter = new DecimalFormat("###,###,###");
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");
    Document document = new Document();
    FileOutputStream file;
    JFrame jf = new JFrame();
    FileDialog fd = new FileDialog(jf, "Xuất pdf", FileDialog.SAVE);
    Font fontData;
    Font fontTitle;
    Font fontHeader;

    public WritePDF() {
        try {
            fontData = new Font(BaseFont.createFont("lib/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11, Font.NORMAL);
            fontTitle = new Font(BaseFont.createFont("lib/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 25, Font.NORMAL);
            fontHeader = new Font(BaseFont.createFont("lib/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11, Font.NORMAL);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(WritePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void chooseURL(String url) {
        try {
            document.close();
            document = new Document();
            file = new FileOutputStream(url);
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Khong tim thay duong dan file " + url);
        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null, "Khong goi duoc document !");
        }
    }

    public void setTitle(String title) {
        try {
            Paragraph pdfTitle = new Paragraph(new Phrase(title, fontTitle));
            pdfTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(pdfTitle);
            document.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
    }

    private String getFile(String name) {
        fd.pack();
        fd.setSize(800, 600);
        fd.validate();
        Rectangle rect = jf.getContentPane().getBounds();
        double width = fd.getBounds().getWidth();
        double height = fd.getBounds().getHeight();
        double x = rect.getCenterX() - (width / 2);
        double y = rect.getCenterY() - (height / 2);
        Point leftCorner = new Point();
        leftCorner.setLocation(x, y);
        fd.setLocation(leftCorner);
        fd.setFile(name + ".pdf");
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("null")) {
            return null;
        }
        return url;
    }

   
    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void writePhieuXuat(String mapn , String nguoitao) {
    	SanPhamBUS spBUS = new SanPhamBUS();
    	if(spBUS.getList() == null) spBUS.list();
        String url = "";
        try {
            fd.setTitle("In phiếu Xuất");
            fd.setLocationRelativeTo(null);
            url = getFile(mapn);
            if (url == null) {
                return;
            }
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();

            setTitle("THÔNG TIN PHIẾU XUẤT");

            PhieuXuatDTO pn = PhieuXuatDAO.getInstance().selectById(mapn);

            Paragraph para1 = new Paragraph(new Phrase("Mã phiếu: " + mapn, fontData));
            Paragraph para2 = new Paragraph(new Phrase("Thời gian tạo: " + formatDate.format(pn.getThoiGianTao()), fontData));
            Paragraph para3 = new Paragraph(new Phrase("Người tạo: " + nguoitao, fontData));
            para1.setIndentationLeft(40);
            para2.setIndentationLeft(40);
            para3.setIndentationLeft(40);
            document.add(para1);
            document.add(para2);
            document.add(para3);
            document.add(Chunk.NEWLINE);//add hang trong de tao khoang cach

            //Tao table cho cac chi tiet cua hoa don
            PdfPTable pdfTable = new PdfPTable(5);
            pdfTable.setWidths(new float[]{10f, 30f, 7f, 14f, 15f});
            PdfPCell cell;

            //Set headers cho table chi tiet
            pdfTable.addCell(new PdfPCell(new Phrase("Mã sản phẩm", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Tên sản phẩm", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Số lượng", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Đơn giá", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Thành tiền", fontHeader)));

            for (int i = 0; i < 5; i++) {
                cell = new PdfPCell(new Phrase(""));
                pdfTable.addCell(cell);
            }

            //Truyen thong tin tung chi tiet vao table
            for (ChiTietPhieu ctpn : ChiTietPhieuXuatDAO.getInstance().selectAll(mapn)) {
//                MayTinh mt = MayTinhDAO.getInstance().selectById(ctpn.getMaMay());
                
                pdfTable.addCell(new PdfPCell(new Phrase(ctpn.getMaMay(), fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(spBUS.PutOnTenSP(ctpn.getMaMay()), fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(String.valueOf(ctpn.getSoLuong()), fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase((spBUS.PutOnGia(ctpn.getMaMay())) + "đ", fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(ctpn.getSoLuong() * spBUS.PutOnGia(ctpn.getMaMay())) + "đ", fontData)));
            }
            document.add(pdfTable);
            document.add(Chunk.NEWLINE);
            Paragraph paraTongThanhToan = new Paragraph(new Phrase("Tổng thanh toán: " + formatter.format(pn.getTongTien()) + "đ", fontData));
            paraTongThanhToan.setIndentationLeft(300);
            document.add(paraTongThanhToan);
            document.close();
            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + url);
            openFile(url);

        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        }

    }
    public void writePhieuNhap(String mapn , String nguoitao , String thoigiantao , String tongtien , String mancc) {
    	SanPhamBUS spBUS = new SanPhamBUS();
    	if(spBUS.getList() == null) spBUS.list();
    	ChiTietPhieuNhapBUS ctpnBUS = new ChiTietPhieuNhapBUS();
    	if(ctpnBUS.getList() == null) ctpnBUS.list();
    
        String url = "";
        try {
            fd.setTitle("In phiếu Nhập");
            fd.setLocationRelativeTo(null);
            url = getFile(mapn);
            if (url == null) {
                return;
            }
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();

            setTitle("THÔNG TIN PHIẾU NHẬP");



            Paragraph para1 = new Paragraph(new Phrase("Mã phiếu: " + mapn, fontData));
            Paragraph para2 = new Paragraph(new Phrase("Thời gian tạo: " + thoigiantao, fontData));
            Paragraph para3 = new Paragraph(new Phrase("Người tạo: " + nguoitao, fontData));
            Paragraph para4 = new Paragraph(new Phrase("Nhà cung cấp: " + mancc, fontData));
            para1.setIndentationLeft(40);
            para2.setIndentationLeft(40);
            para3.setIndentationLeft(40);
            para4.setIndentationLeft(40);
            document.add(para1);
            document.add(para2);
            document.add(para3);
            document.add(para4);
            document.add(Chunk.NEWLINE);//add hang trong de tao khoang cach

            //Tao table cho cac chi tiet cua hoa don
            PdfPTable pdfTable = new PdfPTable(3);
            pdfTable.setWidths(new float[]{10f, 10f, 10f});
            PdfPCell cell;

            //Set headers cho table chi tiet
            pdfTable.addCell(new PdfPCell(new Phrase("Mã sản phẩm", fontHeader)));
         
            pdfTable.addCell(new PdfPCell(new Phrase("Số lượng", fontHeader)));
          
            pdfTable.addCell(new PdfPCell(new Phrase("Thành tiền", fontHeader)));

            for (int i = 0; i < 3; i++) {
                cell = new PdfPCell(new Phrase(""));
                pdfTable.addCell(cell);
            }

            //Truyen thong tin tung chi tiet vao table
            for (ChiTietPhieuNhapDTO ctpn : ctpnBUS.getList()) {
            	System.out.println(ctpn.getMaPNH());
            	System.out.println(mapn);
            	if(ctpn.getMaPNH().equals(mapn)) {
            		pdfTable.addCell(new PdfPCell(new Phrase(ctpn.getMaSP(), fontData)));
            		pdfTable.addCell(new PdfPCell(new Phrase(ctpn.getSoLuong()+ "", fontData)));
            		pdfTable.addCell(new PdfPCell(new Phrase(ctpn.getDonGiaNhap()+ "đ", fontData)));	
            	}
            }
            document.add(pdfTable);
            document.add(Chunk.NEWLINE);
            Paragraph paraTongThanhToan = new Paragraph(new Phrase("Tổng thanh toán: " + tongtien + "đ", fontData));
            paraTongThanhToan.setIndentationLeft(300);
            document.add(paraTongThanhToan);
            document.close();
            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + url);
            openFile(url);

        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        }

    }
}
