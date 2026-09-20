import dao.SinhVienDAO;
import java.util.List;
import model.SinhVien;

public class Main {
    public static void main(String[] args) {
        SinhVienDAO dao = new SinhVienDAO();

        try {
            dao.resetDatabase();

            System.out.println("=================================================");
            System.out.println("   1. DEMO THÊM DỮ LIỆU (CREATE)");
            System.out.println("=================================================");
            dao.themSinhVien(new SinhVien("SV001", "Nguyễn Văn An", 8.5, "CNTT1"));
            dao.themSinhVien(new SinhVien("SV002", "Trần Thị Bình", 6.8, "CNTT1"));
            dao.themSinhVien(new SinhVien("SV003", "Lê Hoàng Cường", 9.2, "CNTT2"));

            System.out.println("\n=================================================");
            System.out.println("   2. DEMO XEM TOÀN BỘ DANH SÁCH (READ)");
            System.out.println("=================================================");
            hienThiDanhSach(dao.layTatCa());

            System.out.println("\n=================================================");
            System.out.println("   3. DEMO TRUY VẤN NATIVE QUERY");
            System.out.println("=================================================");
            System.out.println("🔍 Sinh viên giỏi lớp 'CNTT1' (ĐTB >= 8.0):");
            List<SinhVien> svGioi = dao.timSinhVienGioi("CNTT1", 8.0);
            hienThiDanhSach(svGioi);

            System.out.println("\n=================================================");
            System.out.println("   4. DEMO CẬP NHẬT DỮ LIỆU (UPDATE)");
            System.out.println("=================================================");
            dao.capNhatSinhVien("SV002", "Trần Thị Bình", 8.2, "CNTT1");
            hienThiDanhSach(dao.layTatCa());

            System.out.println("\n=================================================");
            System.out.println("   5. DEMO XÓA DỮ LIỆU (DELETE)");
            System.out.println("=================================================");
            dao.xoaSinhVien("SV001");
            hienThiDanhSach(dao.layTatCa());

        } finally {
            dao.close();
            System.out.println("\n🔒 Đã đóng CSDL db4o an toàn.");
        }
    }

    private static void hienThiDanhSach(List<SinhVien> list) {
        if (list.isEmpty()) {
            System.out.println("   (Danh sách trống)");
            return;
        }
        for (SinhVien sv : list) {
            System.out.println("   " + sv);
        }
    }
}