#include <bits/stdc++.h>
#include "Dpr.cpp"

using namespace std;

int main(){
    list<Dpr> anggota;
    Dpr anggota_awal;
    string masukan;

    anggota_awal.set_id("001");
    anggota_awal.set_name("Amar");
    anggota_awal.set_bidang("Ekonomi");
    anggota_awal.set_partai("PKB");

    anggota.push_back(anggota_awal);

    cout << '\n' << "===SISTEM INFORMASI DAFTAR ANGGOTA DPR===" << '\n';
    cout << '\n' << "Perintah yang diterima : " << '\n';
    cout << "|| lihat || tambah || ubah || hapus ||" << '\n';
    while (masukan != "end"){
        
        cout << '\n' << "Masukkan perintah : ";
        cin >> masukan;

        int i, n = 0;

        string id, name, bidang, partai;

        if(masukan == "tambah"){

            Dpr temp;
            cout << '\n' << "Masukan identitas anggota baru : " << '\n' ;
            cin >> id >> name >> bidang >> partai;

            temp.set_name(name);
            temp.set_id(id);
            temp.set_bidang(bidang);
            temp.set_partai(partai);

            anggota.push_back(temp);
            cout << "Anggota Berhasil Ditambahkan!" << '\n';
        } else if(masukan == "hapus"){
            if(anggota.empty()){
                cout << "List Kosong" << '\n';
            } else{

                string del;
                cout << "Masukan id anggota yang akan dihapus:" << '\n';
                cin >> del;
                list<Dpr>::iterator it = anggota.begin();
                while(it != anggota.end()){
                    if(del == it->get_id()){
                        anggota.erase(it);
                        it = anggota.end();
                        cout << "Anggota Telah Terhapus" << '\n';
                    } else{
                        it++;
                        if(it == anggota.end()){
                            cout << "Anggota tidak ditemukan" << '\n';
                        }
                    }
                }
            }
        } else if(masukan == "lihat"){

            cout << "Anggota DPR : " << '\n';
            if(anggota.empty()){
                cout << "List Kosong" << '\n';
            }

            i = 0;
            for(list<Dpr>::iterator it = anggota.begin(); it != anggota.end(); it++){
                cout << (i + 1) << ". " << it->get_id() << " | " << it->get_name() << " | " << it->get_bidang() << " | " << it->get_partai() << '\n';
                i++;
            }
        } else if(masukan == "ubah"){
            if(anggota.empty()){
                cout << "List Kosong" << '\n';
            } else{

                string ubah, nama_new, bidang_new, partai_new;
                list<Dpr>::iterator it = anggota.begin();
                list<Dpr>::iterator it_found = anggota.begin();

                cout << "Masukan id yang akan diubah:" << '\n';
                cin >> ubah;
                while(it != anggota.end()){
                    if(ubah == it->get_id()){
                        it_found = it;
                        cout << "Anggota ditemukan!" << '\n';
                        cout << it->get_id() << " | " << it->get_id() << " | " << it->get_bidang() << " | " << it->get_partai() << '\n';
                        it = anggota.end();
                    } else{
                        it++;
                        if(it == anggota.end()){
                            cout << "Anggota tidak ditemukan" << '\n';
                        }
                    }
                }

                cout << '\n' << "Masukan data baru: (nama | bidang | partai)" << '\n';
                cin >> nama_new >> bidang_new >> partai_new;

                it_found->set_name(nama_new);
                it_found->set_bidang(bidang_new);
                it_found->set_partai(partai_new);

                cout << "Data telah terubah!" << '\n';

            }
        }
    }
    return 0;
}