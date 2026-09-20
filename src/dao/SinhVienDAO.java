package dao;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import model.SinhVien;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {
    private static final String DB_FILE = "sinhvien.db4o";
    private ObjectContainer db;

    public void open() {
        db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB_FILE);
    }

    public void close() {
        if (db != null && !db.ext().isClosed()) {
            db.close();
        }
    }

    public void resetDatabase() {
        close();
        File file = new File(DB_FILE);
        if (file.exists()) {
            file.delete();
        }
        open();
    }

    public boolean themSinhVien(SinhVien sv) {
        try {
            if (timTheoMa(sv.getMaSV()) != null) {
                System.out.println("❌ Lỗi: Mã sinh viên " + sv.getMaSV() + " đã tồn tại!");
                return false;
            }
            db.store(sv);
            db.commit();
            System.out.println("✅ Đã thêm sinh viên: " + sv.getHoTen());
            return true;
        } catch (Exception e) {
            db.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public List<SinhVien> layTatCa() {
        ObjectSet<SinhVien> result = db.queryByExample(SinhVien.class);
        return new ArrayList<>(result);
    }

    public SinhVien timTheoMa(final String maSV) {
        ObjectSet<SinhVien> result = db.query(new Predicate<SinhVien>() {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean match(SinhVien sv) {
                return sv.getMaSV().equalsIgnoreCase(maSV);
            }
        });

        if (!result.isEmpty()) {
            return result.get(0);
        }
        return null;
    }

    public List<SinhVien> timSinhVienGioi(final String tenLop, final double diemToiThieu) {
        return db.query(new Predicate<SinhVien>() {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean match(SinhVien sv) {
                return sv.getLop().equalsIgnoreCase(tenLop) && sv.getDiemTB() >= diemToiThieu;
            }
        });
    }

    public boolean capNhatSinhVien(String maSV, String hoTenMoi, double diemTBMoi, String lopMoi) {
        SinhVien sv = timTheoMa(maSV);
        if (sv == null) {
            System.out.println("❌ Không tìm thấy sinh viên có mã: " + maSV);
            return false;
        }

        sv.setHoTen(hoTenMoi);
        sv.setDiemTB(diemTBMoi);
        sv.setLop(lopMoi);

        db.store(sv);
        db.commit();
        System.out.println("✅ Đã cập nhật thành công sinh viên có mã: " + maSV);
        return true;
    }

    public boolean xoaSinhVien(String maSV) {
        SinhVien sv = timTheoMa(maSV);
        if (sv == null) {
            System.out.println("❌ Không tìm thấy sinh viên có mã: " + maSV);
            return false;
        }

        db.delete(sv);
        db.commit();
        System.out.println("✅ Đã xóa sinh viên có mã: " + maSV);
        return true;
    }
}