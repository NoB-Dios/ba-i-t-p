import java.util.Objects;
import java.util.Scanner;

public class TP extends NVHC{
    private double luongTrachNhiem;
    public TP(String position, String maNV) {
        super(position, maNV);
    }
    public TP(String position) {
        super(position);
    }
    public TP() {
    }

    @Override
    public void nhapNV(){
        Scanner sc = new Scanner(System.in);
        super.nhapNV();
        System.out.print("Nhập lương trách nhiệm: ");
        this.luongTrachNhiem = sc.nextDouble();
    }
    @Override
    public void xuatNV(){
        super.xuatNV();
        System.out.print("Lương trách nhiệm: " + this.luongTrachNhiem);
    }
    public double getLuongTrachNhiem() {
        return luongTrachNhiem;
    }
    @Override
    public double getLuong(){
        return super.getLuong() + this.luongTrachNhiem;
    }
    @Override
    public double getLuongSauThue(){
        return getLuong() - super.getThue();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TP tp = (TP) o;
        return Objects.equals(super.getPosition(), tp.getPosition()) && Objects.equals(getMaNV(), tp.getMaNV());
    }
    @Override
    public String toString() {
        return  "[ "+this.getPosition()+"-"+getMaNV()+" ]" +
                " [ Họ tên: "+getFullname()+" == Lương: "+nb.format(getLuong())+" == Tiền trách nhiệm: "+this.luongTrachNhiem+" == Lương thực nhận: "+nb.format(getLuongSauThue())+" ]";
    }
}
