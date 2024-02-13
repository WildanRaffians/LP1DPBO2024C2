/*Saya Wildan Hafizh Raffianshar NIM [2202301] mengerjakan soal Latihan Praktikum-1 
dalam mata kuliah DPBO untuk keberkahanNya maka saya tidak melakukan kecurangan 
seperti yang telah dispesifikasikan. Aamiin*/

//import library yang dibutuhkan
import java.util.Scanner;
import java.util.ArrayList;

//Kelas Main
public class Main {
    public static void main(String[] args){

        //inisialisasi
        ArrayList<Dpr> anggota = new ArrayList<>(); //list anggota DPR
        Dpr anggota_awal = new Dpr();               //instantiation
        Scanner sc = new Scanner(System.in);        //scanner
        String masukan = "";                        //masukan perintah
        String[] head = new String[4];              //header tabel
        
        //menyiapkan header untuk tabel
        head[0] = "Id";
        head[1] = "Nama";
        head[2] = "Bidang";
        head[3] = "Partai";
        
        //menyiapkan anggota awal
        anggota_awal.setId("001");
        anggota_awal.setName("Amar");
        anggota_awal.setBidang("Ekonomi");
        anggota_awal.setPartai("PKB");
        
        //memasukkan kedalam list
        anggota.add(anggota_awal);
        
        //tampilan awal
        System.out.println("\n===SISTEM INFORMASI LIST ANGGOTA DPR=== ");
        System.out.println("\nPerintah yang diterima :  ");
        System.out.println("======================================================");
        System.out.println("|| lihat || tambah || ubah || hapus || end (keluar) ||");
        System.out.println("======================================================");
        
        //perulangan selama masukan bukan "end"
        while (masukan.compareTo("end") != 0) {
            System.out.print("\nMasukkan perintah : "); 
            //meminta masukan
            masukan = sc.next();
            int i;
            String id, name, bidang, partai;
            
            //cek masukan
            if(masukan.compareTo("tambah") == 0){
                //jika masukan adalah tambah
                Dpr temp = new Dpr(); //instansiasi
                
                //masukan data anggota baru
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
                
                //set anggota
                temp.setId(id);
                temp.setName(name);
                temp.setBidang(bidang);
                temp.setPartai(partai);

                //tambahkan anggota ke list
                anggota.add(temp);
                System.out.println("\n >> Anggota Berhasil Ditambahkan! <<");

            } else if(masukan.compareTo("lihat") == 0){
                //jika perintah adalah lihat
                if(anggota.isEmpty()){
                    System.out.println("\n >> List Kosong! <<");
                } 

                System.out.println("\nAnggota DPR : ");

                //siapkan array string 2d
                String[][] listAnggota = new String[anggota.size()][4];
                for(i = 0; i < anggota.size(); i++) {
                    listAnggota[i][0] = anggota.get(i).getId();
                    listAnggota[i][1] = anggota.get(i).getName();
                    listAnggota[i][2] = anggota.get(i).getBidang();
                    listAnggota[i][3] = anggota.get(i).getPartai();
                }
                
                //tampilkan tabel
                Tabel tab = new Tabel();
                tab.buatTabel(anggota.size(), 4, listAnggota, head);
                    
            }else if(masukan.compareTo("hapus") == 0){
                //jika perintah adalah hapus
                if(anggota.isEmpty()){
                    //jika list kosong
                    System.out.println("\n >> List Kosong! <<");
                } else{
                    //jika tidak

                    //minta masukan id anggota yang akan dihapus
                    System.out.print("\nMasukkan id anggota yang akan dihapus : ");
                    String del;
                    del = sc.next();

                    //cari anggota
                    i = 0;
                    while(i < anggota.size()){
                        if(del.compareTo(anggota.get(i).getId()) == 0){
                            //jika ketemu
                            anggota.remove(i);
                            i = anggota.size();
                            System.out.println("\n >> Anggota Telah Terhapus! <<");
                        }else{
                            i++;
                            if(i == anggota.size()){
                                //jika sampai ujung list tidak ketemu
                                System.out.println("\n >> Anggota Tidak Ditemukan! <<");
                            }
                        }
                    }

                }
            } else if(masukan.compareTo("ubah") == 0){
                //jika perintah adalah ubah
                if(anggota.isEmpty()){
                    //jika list kosong
                    System.out.println("\n >> List Kosong! <<");
                } else{
                    //jika tidak
                    String ubah, nama_new, bidang_new, partai_new;
                    i = 0;
                    
                    //meminta masukan id yang akan diubah datanya
                    System.out.print("\nMasukan Id yang akan diubah : ");
                    ubah = sc.next();
                    
                    //mencari anggota
                    while(i < anggota.size()){
                        if(ubah.compareTo(anggota.get(i).getId()) == 0){
                            //ketemu
                            System.out.println("\n >> Anggota Ditemukan! << ");
                            
                            //tampilkan anggota yang dicari
                            String[][] listAnggota = new String[1][4];
                            listAnggota[0][0] = anggota.get(i).getId();
                            listAnggota[0][1] = anggota.get(i).getName();
                            listAnggota[0][2] = anggota.get(i).getBidang();
                            listAnggota[0][3] = anggota.get(i).getPartai();
                            
                            //dalam bentuk tabel
                            Tabel tab_ubah = new Tabel();
                            tab_ubah.buatTabel(1, 4, listAnggota, head);
                    
                            //meminta masukan data baru
                            System.out.println("\nMasukkan data baru!");
                            System.out.print("Nama : ");
                            sc.nextLine();
                            nama_new = sc.nextLine();
                            System.out.print("Bidang : ");
                            bidang_new = sc.nextLine();
                            System.out.print("Partai : ");
                            partai_new = sc.nextLine();

                            //set
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
                //jika perintah end
                System.out.println("\n >> Terima Kasih Telah Menjalankan Tugas Sebaik-baiknya! <<");
            } else{
                //perintah lain tidak diterima / tidak valid
                System.out.println("\n >> Perintah Tidak Valid! <<");
            }
        
        }

        sc.close();

    }
}
