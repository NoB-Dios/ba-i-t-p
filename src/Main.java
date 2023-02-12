import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static void taoMenu(ArrayList<NVHC> ds){
        System.out.print("\n           === ỨNG DỤNG QUẢN LÝ ===");
        System.out.print("\n+=============================================+");
        System.out.print("\n|   ❶.Nhập DS nhân viên.                      |" +
                         "\n|   ❷.Xuất DS nhân viên.                      |" +
                         "\n|   ❸.Tìm, hiển thị nhân viên theo mã.        |" +
                         "\n|   ❹.Xóa nhân viên theo mã.                  |" +
                         "\n|   ❺.Cập nhật thông tin theo mã.             |" +
                         "\n|   ❻.Tìm nhân viên theo khoảng lương.        |" +
                         "\n|   ❼.Sắp xếp nhân viên theo họ tên.          |" +
                         "\n|   ❽.Sắp xếp nhân viên theo thu nhập.        |" +
                         "\n|   ❾.Xuất 5 nhân viên thu nhập cao nhất.     |" +
                         "\n|   ⓿.Thoát.                                  |");
        System.out.print("\n+=============================================+");
    }
    static void nhapDS(ArrayList<NVHC> ds){
        System.out.println("Chức vụ nhân viên ?\n1.Hành Chính\n2.Tiếp Thị\n3.Trưởng Phòng");
        sc.nextLine();
        System.out.print("Nhập lựa chọn: ");
        int chon = sc.nextInt();
        if (chon > 0 && chon <= 3) {
            System.out.print("Nhập số lượng nhân viên: ");
            int n = sc.nextInt();
            switch (chon) {
                case 1:
                    for (int i = 0; i < n; i++) {
                        NVHC nvhc = new NVHC("HC");
                        nvhc.nhapNV();
                        ds.add(nvhc);
                    }
                    break;
                case 2:
                    for (int i = 0; i < n; i++) {
                        NVTT nvtt = new NVTT("TT");
                        nvtt.nhapNV();
                        ds.add(nvtt);
                    }
                    break;
                case 3:
                    for (int i = 0; i < n; i++) {
                        TP tp = new TP("TP");
                        tp.nhapNV();
                        ds.add(tp);
                    }
                    break;
            }
        }
        else {
            System.out.println("Phòng Ban chọn không tồn tại, tự động thoát khỏi menu.");
        }
    }
    static void xuatDS(ArrayList<NVHC> ds){
        for (Object i : ds) {
            System.out.println(i);
        }
    }
    static boolean checkDS(ArrayList<NVHC> ds, String x){
        boolean check = false;
        for(NVHC nvhc : ds){
            if(nvhc.getMaNV().contains(x)) {
                check = true;
            }
        }
        return check;
    }
    static void timDS(ArrayList<NVHC> ds){
        System.out.print("Nhập mã nhân viên: ");
        sc.nextLine();
        String x = sc.nextLine();
        for (NVHC nv : ds){
            if (nv.getMaNV().contains(x)){
                System.out.println(nv);
            }
        }
        if (checkDS(ds,x) == false){
            System.out.println("Không tìm thấy nhân viên.");
        }
    }
    static void xoaDS(ArrayList<NVHC> ds){
        boolean check = false;
        System.out.print("Nhập mã nhân viên: ");
        sc.nextLine();
        String x = sc.nextLine();
        for(int i = 0 ; i < ds.size() ; i++) {
            if (ds.get(i).getMaNV().contains(x)) {
                ds.remove(ds.get(i));
                System.out.println("Đã xóa !");
                check = true;
                break;
            }
        }
        if (check == false){
            System.out.println("Không tìm thấy nhân viên cần xóa !");
        }

    }
    static void updateDS(ArrayList<NVHC> ds){
        boolean check = false;
        System.out.print("Nhập mã nhân viên: ");
        sc.nextLine();
        String x = sc.nextLine();
        for (int i = 0 ; i < ds.size() ; i++) {
            if (ds.get(i).getMaNV().contains(x)) {
                check = true;
                System.out.println("Chức vụ nhân viên ?\n1.Hành Chính\n2.Tiếp Thị\n3.Trưởng Phòng");
                System.out.print("Nhập lựa chọn: ");
                int chon = sc.nextInt();
                switch (chon) {
                    case 1:
                        NVHC nv = new NVHC("HC");
                        nv.nhapNV();
                        ds.set(i,nv);
                        break;
                    case 2:
                        NVTT nvtt = new NVTT("TT");
                        nvtt.nhapNV();
                        ds.set(i,nvtt);
                        break;
                    case 3:
                        TP tp = new TP("TP");
                        tp.nhapNV();
                        ds.set(i,tp);
                        break;
                }
                if (chon < 1 && chon > 3 ){
                    System.out.println("Phòng Ban chọn không tồn tại, tự động thoát khỏi menu.");
                    break;
                }
            }
            if (check == false){
                System.out.println("Không tìm thấy nhân viên.");
            }
        }
    }
    static void timDSluong(ArrayList<NVHC> ds){
        boolean check = false;
        System.out.print("Nhập vào lương nhỏ nhất: ");
        double x = sc.nextDouble();
        System.out.print("Nhập vào lương lớn nhất: ");
        double z = sc.nextDouble();
        for (int i = 0 ; i < ds.size() ; i++){
            if(ds.get(i).getLuong() >= x && ds.get(i).getLuong() <= z){
                System.out.println(ds.get(i));
                check = true;
            }
        }
        if (check == false){
            System.out.println("Không tìm thấy nhân viên.");
        }
    }
    static void sapXepTheoTen(ArrayList<NVHC> ds){
        Collections.sort(ds, new Comparator<NVHC>() {
            @Override
            public int compare(NVHC o1, NVHC o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }
    static void sapXepTheoLuong(ArrayList<NVHC> ds){
        Collections.sort(ds, new Comparator<NVHC>() {
            @Override
            public int compare(NVHC o1, NVHC o2) {
                return (int) (o2.getLuong() - o1.getLuong());
            }
        });
    }
    static void xuatThuNhapCao(ArrayList<NVHC> ds){
        sapXepTheoLuong(ds);
        int check = 0;
        System.out.println("               === 5 Nhân viên có thu nhập cao nhất ===");
        for (int i = 0 ; i < ds.size() ; i++){
            System.out.println(ds.get(i));
            check++;
            if (check == 5){
                break;
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<NVHC> ds = new ArrayList<NVHC>();
        int luaChon = 0;
        String user = "admin";
        String pass = "admin";
        System.out.println("\nChào mừng bạn đến với ỨNG DỤNG QUẢN LÝ nhân viên.");
        System.out.println("Mời nhập tài khoản và mật khẩu để tiếp tục.");
        System.out.print("Tài khoản: ");
        String tk = sc.nextLine();
        System.out.print("Mật khẩu: ");
        String mk = sc.nextLine();
        int rs = 3;
        while (tk.compareTo(user) != 0 || mk.compareTo(pass) != 0){
            System.out.println("Sai tài khoản hoặc mật khẩu, bạn còn " + rs + " lần nhập, mời nhập lại. ");
            System.out.print("Tài khoản: ");
            tk = sc.nextLine();
            System.out.print("Mật khẩu: ");
            mk = sc.nextLine();
            rs--;
            if (rs == 0){
                break;
            }
        }
        if(tk.compareTo(user) == 0 && mk.compareTo(pass) == 0) {
            do {
                taoMenu(ds);
                System.out.print("\nNhập lựa chọn: ");
                luaChon = sc.nextInt();
                if (luaChon >= 0 && luaChon <= 9) {
                    switch (luaChon) {
                        case 1:
                            nhapDS(ds);
                            break;
                        case 2:
                            xuatDS(ds);
                            break;
                        case 3:
                            timDS(ds);
                            break;
                        case 4:
                            xoaDS(ds);
                            break;
                        case 5:
                            updateDS(ds);
                            break;
                        case 6:
                            timDSluong(ds);
                            break;
                        case 7:
                            sapXepTheoTen(ds);
                            System.out.println("Danh sách sau khi sắp xếp (bảng chữ cái)");
                            xuatDS(ds);
                            break;
                        case 8:
                            sapXepTheoLuong(ds);
                            System.out.println("Danh sách sau khi sắp xếp (giảm dần)");
                            xuatDS(ds);
                            break;
                        case 9:
                            xuatThuNhapCao(ds);
                            break;
                        case 0:
                            luaChon = 0;
                            break;
                    }
                    if (luaChon != 0){
                        System.out.print("Bạn có muốn tiếp tục ?\n1. Có\n0. Không\nNhập lựa chọn: ");
                        luaChon = sc.nextInt();
                    }
                }
                else {
                    System.out.println("Vượt lựa chọn cho phép, tự động thoát !");
                    luaChon = 0 ;
                }
            } while (luaChon != 0);
        }
        else {
            System.out.println("Nhập quá giới hạn, tự động thoát.");
        }
    }
}