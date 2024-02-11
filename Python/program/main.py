from Dpr import Dpr
from Tabel import Tabel

anggotaDpr = []

anggotaDpr.append(Dpr("001", "Amar", "Ekonomi", "PKB"))

print("\n===SISTEM INFORMASI LIST ANGGOTA DPR=== ")
print("\nPerintah yang diterima :  ")
print("======================================================")
print("|| lihat || tambah || ubah || hapus || end (keluar) ||")
print("======================================================")

masukan = ""
headTabel = ["Id", "Nama", "Bidang", "Partai"]

while(masukan != "end"):
    masukan = str(input('\nMasukkan Perintah: '))

    if(masukan == "tambah"):
        print("\nMasukkan identitas anggota baru : ")
        id = str(input('Id : '))
        name = str(input('Nama : '))
        bidang = str(input('Bidang : '))
        partai = str(input('Partai : '))

        anggotaDpr.append(Dpr(id, name, bidang, partai))
        print("\n >> Anggota Berhasil Ditambahkan! <<")
    
    elif(masukan == "lihat"):
        if not anggotaDpr:
            print("\nList kosong.")
        
        print("\nAnggota DPR :")

        listAnggota = [[0 for _ in range(4)] for _ in range(len(anggotaDpr))]
        i = 0
        for anggota in anggotaDpr:
            listAnggota[i][0] = anggota.get_id()
            listAnggota[i][1] = anggota.get_name()
            listAnggota[i][2] = anggota.get_bidang()
            listAnggota[i][3] = anggota.get_partai()
            i+=1

        tab = Tabel()
        

        tab.buat_tabel(len(anggotaDpr), 4, listAnggota, headTabel)

    elif(masukan == "hapus"):
        if not anggotaDpr:
            print("\n >> List kosong. <<")
        else:
            hapus_id = str(input('\nMasukkan id anggota yang akan dihapus: '))
            id_found = False
            for anggota in anggotaDpr:
                if(anggota.get_id() == hapus_id):
                    anggotaDpr.remove(anggota)
                    id_found = True
                    print("\n >> Anggota Telah Terhapus! <<")

            if(id_found == False):
                print("\n >> Anggota Tidak Ditemukan! <<")
    
    elif(masukan == "ubah"):
        if not anggotaDpr:
            print("\n >> List kosong <<")
        else:
            ubah_id = str(input('\nMasukkan id anggota yang akan diubah: '))
            
            id_found = False
            for anggota in anggotaDpr:
                if(anggota.get_id() == ubah_id):
                    print("\n >> Anggota Ditemukan! <<\n")
                    listAnggota = [[0 for _ in range(4)] for _ in range(len(anggotaDpr))]
                    
                    listAnggota[0][0] = anggota.get_id()
                    listAnggota[0][1] = anggota.get_name()
                    listAnggota[0][2] = anggota.get_bidang()
                    listAnggota[0][3] = anggota.get_partai()

                    tab_ubah = Tabel()
                    tab_ubah.buat_tabel(1, 4, listAnggota, headTabel)
                    
                    print("\nMasukkan data baru!")
                    nama_new = str(input('Nama : '))
                    bidang_new = str(input('Bidang : '))
                    partai_new = str(input('Partai : '))

                    anggota.set_name(nama_new)
                    anggota.set_bidang(bidang_new)
                    anggota.set_partai(partai_new)

                    id_found = True
                    print("\n >> Anggota Telah Terubah! <<")

            if(id_found == False):
                print("\n >> Anggota Tidak Ditemukan! <<")
    elif(masukan == "end"):
        print("\n >> Terima Kasih Telah Menjalankan Tugas Sebaik-baiknya! <<")
    else:
        print("\n >> Perintah Tidak Valid! <<")