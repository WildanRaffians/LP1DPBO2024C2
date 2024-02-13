# Saya Wildan Hafizh Raffianshar NIM [2202301] mengerjakan soal Latihan Praktikum-1 
# dalam mata kuliah DPBO untuk keberkahanNya maka saya tidak melakukan kecurangan 
# seperti yang telah dispesifikasikan. Aamiin

# Siapkan Kelas
from Dpr import Dpr
from Tabel import Tabel

anggotaDpr = []             #list penampung anggota dpr
masukan = ""                #isi perintah masukan
headTabel = ["Id", "Nama", "Bidang", "Partai"]

# isi oleh anggota awal
anggotaDpr.append(Dpr("001", "Amar", "Ekonomi", "PKB"))

# tampilan awal
print("\n===SISTEM INFORMASI LIST ANGGOTA DPR=== ")
print("\nPerintah yang diterima :  ")
print("======================================================")
print("|| lihat || tambah || ubah || hapus || end (keluar) ||")
print("======================================================")

#perulangan selama masukan bukan end
while(masukan != "end"):

    # Meminta masukan perintah
    masukan = str(input('\nMasukkan Perintah: '))

    # cek perintah
    if(masukan == "tambah"):
        # jika perintah adalah tambah
        # meminta masukan data anggota baru
        print("\nMasukkan identitas anggota baru : ")
        id = str(input('Id : '))
        name = str(input('Nama : '))
        bidang = str(input('Bidang : '))
        partai = str(input('Partai : '))

        # masukan data ke list
        anggotaDpr.append(Dpr(id, name, bidang, partai))
        print("\n >> Anggota Berhasil Ditambahkan! <<")
    
    elif(masukan == "lihat"):
        # jika perintah adalah lihat

        if not anggotaDpr:
            # jika list kosong
            print("\nList kosong.")
        
        # tampilkan list anggota
        print("\nAnggota DPR :")

        listAnggota = [[0 for _ in range(4)] for _ in range(len(anggotaDpr))]
        i = 0
        for anggota in anggotaDpr:
            listAnggota[i][0] = anggota.get_id()
            listAnggota[i][1] = anggota.get_name()
            listAnggota[i][2] = anggota.get_bidang()
            listAnggota[i][3] = anggota.get_partai()
            i+=1

        # Dalam bentuk tabel
        tab = Tabel()
        tab.buat_tabel(len(anggotaDpr), 4, listAnggota, headTabel)

    elif(masukan == "hapus"):
        # jika perintah adalah hapus
        if not anggotaDpr:
            # jika list kosong
            print("\n >> List kosong. <<")
        else:
            # jika tidak
            # meminta masukan id anggota yang akan dihapus
            hapus_id = str(input('\nMasukkan id anggota yang akan dihapus: '))
            id_found = False

            # cari anggota
            for anggota in anggotaDpr:
                if(anggota.get_id() == hapus_id):
                    # jika ketemu
                    # hapus
                    anggotaDpr.remove(anggota)
                    id_found = True
                    print("\n >> Anggota Telah Terhapus! <<")

            if(id_found == False):
                # jika tidak ketemu
                print("\n >> Anggota Tidak Ditemukan! <<")
    
    elif(masukan == "ubah"):
        # Jika perintah masukan adalah ubah
        if not anggotaDpr:
            # jika list kosong
            print("\n >> List kosong <<")
        else:
            # jika tidak
            # meminta masukan id anggota yang datanya akan diubah
            ubah_id = str(input('\nMasukkan id anggota yang akan diubah: '))
            
            # cari anggota
            id_found = False
            for anggota in anggotaDpr:
                if(anggota.get_id() == ubah_id):
                    # jika ketemu
                    # tampilkan
                    print("\n >> Anggota Ditemukan! <<\n")
                    listAnggota = [[0 for _ in range(4)] for _ in range(len(anggotaDpr))]
                    listAnggota[0][0] = anggota.get_id()
                    listAnggota[0][1] = anggota.get_name()
                    listAnggota[0][2] = anggota.get_bidang()
                    listAnggota[0][3] = anggota.get_partai()

                    # dalam tabel
                    tab_ubah = Tabel()
                    tab_ubah.buat_tabel(1, 4, listAnggota, headTabel)
                    
                    # meminta masukan data baru
                    print("\nMasukkan data baru!")
                    nama_new = str(input('Nama : '))
                    bidang_new = str(input('Bidang : '))
                    partai_new = str(input('Partai : '))

                    # set
                    anggota.set_name(nama_new)
                    anggota.set_bidang(bidang_new)
                    anggota.set_partai(partai_new)

                    id_found = True
                    print("\n >> Anggota Telah Terubah! <<")

            if(id_found == False):
                # jika anggota tidak ditemukan
                print("\n >> Anggota Tidak Ditemukan! <<")
    elif(masukan == "end"):
        # jika perintah masukan adalah end
        print("\n >> Terima Kasih Telah Menjalankan Tugas Sebaik-baiknya! <<")
    else:
        # jika perintah lain maka tidak valid
        print("\n >> Perintah Tidak Valid! <<")