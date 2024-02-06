/*Saya Wildan Hafizh Raffianshar NIM [2202301] mengerjakan soal Latihan Praktikum-1 
dalam mata kuliah DPBO untuk keberkahanNya maka saya tidak melakukan kecurangan 
seperti yang telah dispesifikasikan. Aamiin*/

//import library dan file class
#include <bits/stdc++.h>
#include "Dpr.cpp"

//using standard namespace
using namespace std;

//main
int main(){
    list<Dpr> anggota;  //list anggota DPR
    Dpr anggota_awal;   //Instantiation, anggota awal untuk mengisi list
    string masukan;     //penampung perintah masukan

    //mengisi nilai atribut
    anggota_awal.set_id("001");
    anggota_awal.set_name("Amar");
    anggota_awal.set_bidang("Ekonomi");
    anggota_awal.set_partai("PKB");

    //memasukkan kedalam list
    anggota.push_back(anggota_awal);

    //tampilan awal
    cout << '\n' << "===SISTEM INFORMASI DAFTAR ANGGOTA DPR===" << '\n';
    cout << '\n' << "Perintah yang diterima : " << '\n';
    cout << "|| lihat || tambah || ubah || hapus ||" << '\n';

    //perulangan masukan perintah
    while (masukan != "end"){
        //selama perintah bukan "end"

        //minta masukan perintah
        cout << '\n' << "Masukkan perintah : ";
        cin >> masukan;

        //inisialisasi
        int i, n = 0;
        string id, name, bidang, partai;

        //mengecek masukan perintah
        if(masukan == "tambah"){
            //jika masukan perintah tambah

            Dpr temp;   //penampng sementara

            //meminta masukkan data anggota baru
            cout << '\n' << "Masukkan identitas anggota baru : " << '\n' ;
            cin >> id >> name >> bidang >> partai;

            //masukkan pada object tempt
            temp.set_name(name);
            temp.set_id(id);
            temp.set_bidang(bidang);
            temp.set_partai(partai);

            //masukkan kedalam list
            anggota.push_back(temp);
            cout << "Anggota Berhasil Ditambahkan!" << '\n';

        } else if(masukan == "hapus"){
            //jika masukan perintah hapus

            if(anggota.empty()){
                //jika list kosong
                cout << "List Kosong" << '\n';
            } else{
                //jika list tidak kosong

                string del; //penampung id anggota yang akan dihapus

                cout << "Masukkan id anggota yang akan dihapus:" << '\n';
                //meminta masukan id anggota yang akan dihapus
                cin >> del;

                list<Dpr>::iterator it = anggota.begin();
                //mencari id yang akan dihapus
                while(it != anggota.end()){
                    //telusuri list
                    if(del == it->get_id()){
                        //jika id ditemukan
                        //hapus anggota tersebut
                        anggota.erase(it);
                        //set it ke akhir agar mengakhiri loop
                        it = anggota.end();
                        cout << "Anggota Telah Terhapus!" << '\n';
                    } else{
                        //jika id belum ketemu
                        it++;//iterasi

                        //jika sampai akhir id tidak ketemu
                        if(it == anggota.end()){
                            //berarti id tidak ada
                            cout << "Anggota tidak ditemukan" << '\n';
                        }
                    }
                }
            }
        } else if(masukan == "lihat"){
            //jika masukan perintah lihat

            //tampilkan seluruh isi list
            cout << "Anggota DPR : " << '\n';
            if(anggota.empty()){
                //jika kosong
                cout << "List Kosong" << '\n';
            } else{
                //jika tidak
                i = 0;
                for(list<Dpr>::iterator it = anggota.begin(); it != anggota.end(); it++){
                    cout << (i + 1) << ". " << it->get_id() << " | " << it->get_name() << " | " << it->get_bidang() << " | " << it->get_partai() << '\n';
                    i++;
                }
            }

        } else if(masukan == "ubah"){
            //jika perintah masukan ubah

            if(anggota.empty()){
                //jika list kosong
                cout << "List Kosong" << '\n';
            } else{
                //jika list tidak kosong

                //deklarasi
                string ubah, nama_new, bidang_new, partai_new;
                list<Dpr>::iterator it = anggota.begin();

                //meminta id anggota yang akan diubah
                cout << "Masukkan id yang akan diubah:" << '\n';
                cin >> ubah;

                //mencari id yang akan diubah
                while(it != anggota.end()){
                    //telusuri list
                    if(ubah == it->get_id()){
                        //jika ditemukan
                        cout << "Anggota ditemukan!" << '\n';

                        //tampilkan
                        cout << it->get_id() << " | " << it->get_name() << " | " << it->get_bidang() << " | " << it->get_partai() << '\n';
                        cout << '\n' << "Masukkan data baru: (nama | bidang | partai)" << '\n';
                        
                        //meminta data baru, hanya nama, bidang dan partai
                        //Id tidak dapat diubah
                        cin >> nama_new >> bidang_new >> partai_new;

                        //set atribut yang baru agar terubah
                        it->set_name(nama_new);
                        it->set_bidang(bidang_new);
                        it->set_partai(partai_new);

                        cout << "Data telah terubah!" << '\n';

                        //akhiri loop
                        it = anggota.end();
                    } else{
                        //jika id belum ketemu
                        it++;//iterasi

                        //jika sampai akhir id tidak ketemu
                        if(it == anggota.end()){
                            //berarti id tidak ada
                            cout << "Anggota tidak ditemukan" << '\n';
                        }
                    }
                }


            }
        }
    }

    //tampilkan jika telah keluar dari loop meminta masukan
    cout << '\n' << "Jalankan Tugas Sebaik-baiknya!" << '\n';
    
    return 0;
}