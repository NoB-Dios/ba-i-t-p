import java.util.Objects;
import java.util.Scanner;

public class NVTT extends NVHC{
    private double doanhSo;
    private double hoaHong;

    public NVTT(String position, String maNV) {
        super(position, maNV);
    }
    public NVTT(String position) {
        super(position);
    }
    public NVTT() {
    }

    @Override
    public void nhapNV(){
        Scanner sc = new Scanner(System.in);
        super.nhapNV();
        System.out.print("Nhập doanh số: ");
        this.doanhSo = sc.nextDouble();
        System.out.print("Nhập hoa hồng: ");
        this.hoaHong = sc.nextDouble();
    }
    @Override
    public void xuatNV(){
        super.xuatNV();
        System.out.print("Doanh số: " + this.doanhSo);
        System.out.print("Hoa hồng: " + this.hoaHong);
    }
    @Override
    public double getLuong(){
        return (super.getLuong() + (this.doanhSo * (this.hoaHong / 100)));
    }
    @Override
    public double getLuongSauThue(){
        return getLuong() - super.getThue();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NVTT nvtt = (NVTT) o;
        return Objects.equals(super.getPosition(), nvtt.getPosition()) && Objects.equals(getMaNV(), nvtt.getMaNV());
    }
    @Override
    public String toString() {
        return  "[ "+getPosition()+ "-"+getMaNV()+" ]"+
                " [ Họ tên: "+getFullname()+" == Lương: "+ getLuong()+" == Doanh số " + this.doanhSo+" == Hoa hồng: "+this.hoaHong+" == Lương thực nhận: "+getLuongSauThue()+" ]";
    }
}
