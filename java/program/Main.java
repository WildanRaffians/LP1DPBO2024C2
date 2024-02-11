import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Dpr> anggota = new ArrayList<>();
        Dpr anggota_awal = new Dpr();
        
        anggota_awal.setId("001");
        anggota_awal.setName("Amar");
        anggota_awal.setBidang("Ekonomi");
        anggota_awal.setPartai("PKB");
        
        anggota.add(anggota_awal);
        
        System.out.println("\n===SISTEM INFORMASI LIST ANGGOTA DPR=== ");
        System.out.println("\nPerintah yang diterima :  ");
        System.out.println("======================================================");
        System.out.println("|| lihat || tambah || ubah || hapus || end (keluar) ||");
        System.out.println("======================================================");
        
        Scanner sc = new Scanner(System.in);
        String masukan = "";
        String[] head = new String[4];
        head[0] = "Id";
        head[1] = "Nama";
        head[2] = "Bidang";
        head[3] = "Partai";
        while (masukan.compareTo("end") != 0) {
            System.out.print("\nMasukkan perintah : ");
            masukan = sc.next();
            int i;
            String id, name, bidang, partai;
            
            if(masukan.compareTo("tambah") == 0){
                Dpr temp = new Dpr();
                
                System.out.println("\nMasukkan identitas anggota baru!");
                System.out.print("Id : ");
                id = sc.next();
                sc.nextLine();
                System.out.print("Nama : ");
                name = sc.nextLine();
                System.out.print("Bidang : ");
                bidang = sc.nextLine();
                System.out.print("Partai : ");
                partai = sc.nextLine();

                temp.setId(id);
                temp.setName(name);
                temp.setBidang(bidang);
                temp.setPartai(partai);

                anggota.add(temp);
                System.out.println("\n >> Anggota Berhasil Ditambahkan! <<");

            } else if(masukan.compareTo("lihat") == 0){

                if(anggota.isEmpty()){
                    System.out.println("\n >> List Kosong! <<");
                } 

                System.out.println("\nAnggota DPR : ");

                String[][] listAnggota = new String[anggota.size()][4];
                
                for(i = 0; i < anggota.size(); i++) {
                    listAnggota[i][0] = anggota.get(i).getId();
                    listAnggota[i][1] = anggota.get(i).getName();
                    listAnggota[i][2] = anggota.get(i).getBidang();
                    listAnggota[i][3] = anggota.get(i).getPartai();
                }
                

                Tabel tab = new Tabel();
                tab.buatTabel(anggota.size(), 4, listAnggota, head);
                    
            }else if(masukan.compareTo("hapus") == 0){
                if(anggota.isEmpty()){
                    System.out.println("\n >> List Kosong! <<");
                } else{
                    
                    System.out.print("\nMasukkan id anggota yang akan dihapus : ");
                    String del;
                    del = sc.next();
                    i = 0;
                    while(i < anggota.size()){
                        if(del.compareTo(anggota.get(i).getId()) == 0){
                            anggota.remove(i);
                            i = anggota.size();
                            System.out.println("\n >> Anggota Telah Terhapus! <<");
                        }else{
                            i++;
                            if(i == anggota.size()){
                                System.out.println("\n >> Anggota Tidak Ditemukan! <<");
                            }
                        }
                    }

                }
            } else if(masukan.compareTo("ubah") == 0){
                if(anggota.isEmpty()){
                    System.out.println("\n >> List Kosong! <<");
                } else{
                    String ubah, nama_new, bidang_new, partai_new;
                    i = 0;

                    System.out.print("\nMasukan Id yang akan diubah : ");
                    ubah = sc.next();

                    while(i < anggota.size()){
                        if(ubah.compareTo(anggota.get(i).getId()) == 0){
                            System.out.println("\n >> Anggota Ditemukan! << ");
                            
                            String[][] listAnggota = new String[1][4];
                            listAnggota[0][0] = anggota.get(i).getId();
                            listAnggota[0][1] = anggota.get(i).getName();
                            listAnggota[0][2] = anggota.get(i).getBidang();
                            listAnggota[0][3] = anggota.get(i).getPartai();
                            

                            Tabel tab_ubah = new Tabel();
                            tab_ubah.buatTabel(1, 4, listAnggota, head);
                    

                            System.out.println("\nMasukkan data baru!");
                            System.out.print("Nama : ");
                            sc.nextLine();
                            nama_new = sc.nextLine();
                            System.out.print("Bidang : ");
                            bidang_new = sc.nextLine();
                            System.out.print("Partai : ");
                            partai_new = sc.nextLine();

                            anggota.get(i).setName(nama_new);
                            anggota.get(i).setBidang(bidang_new);
                            anggota.get(i).setPartai(partai_new);

                            System.out.println("\n >> Data Telah Terubah! <<");

                            i = anggota.size();
                        } else{
                            i++;

                            if(i == anggota.size()){
                                System.out.println("\n >> Anggota Tidak Ditemukan! << ");
                            }
                        }
                    }
                }
            } else if(masukan.compareTo("end") == 0 ){
                System.out.println("\n >> Terima Kasih Telah Menjalankan Tugas Sebaik-baiknya! <<");
            } else{
                System.out.println("\n >> Perintah Tidak Valid! <<");
            }
        
        }

        sc.close();

    }
}
