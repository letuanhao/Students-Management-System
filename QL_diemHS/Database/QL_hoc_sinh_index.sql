use QL_hoc_sinh
/*go
CREATE UNIQUE CLUSTERED INDEX maHS_index_view
on hocsinh_VIEW(maHS);*/

/*go
CREATE NONCLUSTERED INDEX hotenHS_index_view
on hocsinh_VIEW(HoTenHS)*/

/*go
CREATE NONCLUSTERED INDEX sohieu_index_view
on hocsinh_VIEW(SoHieu)*/
/*go
CREATE NONCLUSTERED INDEX hotenHS_index
on HocSinh(HoTenHS)*/
/*go
CREATE NONCLUSTERED INDEX namhk_lop_index
on HocSinhLop(MaNamHocKi,Malop)*/
/*go
CREATE UNIQUE CLUSTERED INDEX IDLopDiemHSView_index
on dbo.Lop_DiemHS_VIEW(ID)
go
CREATE NONCLUSTERED INDEX LopDiemHSView_index
on dbo.Lop_DiemHS_VIEW(maLop,NHK,maMon,maDiem)*/
/*go
CREATE UNIQUE CLUSTERED INDEX maHSLopTKhocki_index
on dbo.Lop_TKHocKi_VIEW(MaHS)
go
CREATE NONCLUSTERED INDEX LopTKhocki_index
on dbo.Lop_TKHocKi_VIEW(Malop,MaNamHocKi)*/
go
CREATE NONCLUSTERED INDEX DanhGiaCK_nh
on DanhGiaCK(MaNamHoc)
/*go
CREATE NONCLUSTERED INDEX LopTKMonVIEW_index
on Lop_TKMon_VIEW(MaLop,MaMonHoc,MaNamHocki)
[dbo].[tongketcanam_view]*/
