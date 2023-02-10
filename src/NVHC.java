import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class NVHC {
    private String position;
    private String maNV;
    private String fullname;
    private double luong;

    public NVHC(String position, String maNV) {
        this.position = position;
        this.maNV = maNV;
    }
    public NVHC(String position) {
        this.position = position;
    }
    public NVHC() {
    }

    public void nhapNV(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã NV: ");;
        this.maNV = sc.nextLine();
        System.out.print("Nhập họ tên: ");
        this.fullname = sc.nextLine();
        System.out.print("Nhập lương: ");
        this.luong = sc.nextDouble();
    }
    public void xuatNV(){
        System.out.print("Mã NV " + this.maNV);
        System.out.print("Họ tên: " + this.fullname);
        System.out.print("Lương: " + this.luong);
    }

    public String getFullname() {
        return fullname;
    }
    public String getPosition() {
        return position;
    }
    public String getMaNV() {
        return maNV;
    }

    public double getLuong() {
        return this.luong;
    }
    public double getThue(){
        double thue = 0;
        if (getLuong() > 9000 && getLuong() <= 15000){
             thue = getLuong() * 0.1;
        }
        if (getLuong() > 15000){
             thue = getLuong() * 0.12;
        }
        return thue;
    }
    public double getLuongSauThue(){
        return getLuong() - getThue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NVHC nvhc = (NVHC) o;
        return Objects.equals(position, nvhc.position) && Objects.equals(maNV, nvhc.maNV);
    }
    @Override
    public String toString() {
        return  "[ "+this.getPosition()+"-"+this.maNV+" ]"+
                " [ Họ tên: "+this.fullname+" == Lương : "+getLuong()+" == Lương thực nhận: "+getLuongSauThue()+" ]";
    }




}
