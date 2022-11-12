package View;

import Model.DanToc;
import Model.DiemChiTiet;
import Model.DienChinhSach;
import Model.HanhKiem;
import Model.HocKi;
import Model.HocLuc;
import Model.HocPhi;
import Model.Lop;
import Model.MonHoc;
import Model.NamHoc;
import Model.TonGiao;
import java.util.List;

public class DataStatic {
    public static List<HocKi> dsHK;
    public static List<NamHoc> dsNH;
    public static List<TonGiao> dsTG;
    public static List<DanToc> dsDT;
    public static List<DiemChiTiet> dsDCT;
    public static List<Lop> dsLop;
    public static List<MonHoc> dsMH;
    public static List<HocLuc> dsHocLuc;
    public static List<HanhKiem> dsHanhKiem;
    public static List<DienChinhSach> dsDSC;
    public static List<HocPhi> dsHP;
    public static String DIEMMIENG="01";
    public static String DIEM15P="02";
    public static String DIEMGK="03";
    public static String DIEMCK="04";
    public static String DIEMTHILAI="05";
    
    //trạng thái của học sinh
    public static final String TT_HS[] ={
            "Nhập học"
            ,"Đang học"
            ,"Lên lớp"
            ,"Thi lại"
            ,"Ở lại lớp"
            ,"Đã tốt nghiệp"
            ,"Chuyển trường"
    };
    
    public static final String TT_CN[] ={
            ""
            ,"Lên lớp"
            ,"Thi lại"
            ,"Ở lại lớp"
    };
    
    
    
    public static final String GTnam ="Nam";
    public static final String GTnu = "Nữ";
    //chuyên môn
    public static final String CM[]={
             "Toán học"
            ,"Vật Lý"
            ,"Hóa học"
            ,"Sinh học"
            ,"Văn học"
            ,"Sử học"
            ,"Địa chất học"
            ,"Ngoại ngữ"
            ,"Công nghệ thông tin"
            ,"Thể thao"
            ,"Nghệ thuật"
            ,"Kỹ thuật"
            ,"Quốc phòng an ninh"
            ,"Giáo dục công dân"
    };
    //trình độ
    public static final String TD[] = {
            "Cao Đẳng"
            ,"Đại Học"
            ,"Thạc sỹ"
            ,"Tiến sĩ"
    };
}
