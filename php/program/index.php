<!-- Saya Wildan Hafizh Raffianshar NIM [2202301] mengerjakan soal Latihan Praktikum-1 
dalam mata kuliah DPBO untuk keberkahanNya maka saya tidak melakukan kecurangan 
seperti yang telah dispesifikasikan. Aamiin -->

<!-- Index / main -->
<?php

    //memanggil file class
    require('Dpr.php');
    require('Tabel.php');

    //menambah anggota DPR
    $anggota1 = new Dpr("001", "Kamisato Ayaka", "Dalam Negeri", "PIS", "<img src = '../foto/ayaya.jpg' widht = '35' height = 35");
    $anggota2 = new Dpr("020", "Sangonomiya Kokomi", "Keuangan", "PPIA", "<img src = '../foto/koko.jpg' widht = '35' height = 35");
    $anggota3 = new Dpr("031", "Kujou Sara", "Pertahanan dan Keamanan", "PPA", "<img src = '../foto/sarah.jpg' widht = '35' height = 35");
    $anggota4 = new Dpr("035", "Chiori", "Busana", "PIBB", "<img src = '../foto/ayaya.jpg' widht = '35' height = 35");
    $anggota5 = new Dpr("051", "Arataki Itto", "Luar Negeri", "PGAI", "<img src = '../foto/ushi.jpg' widht = '35' height = 35");

    $anggotaDpr = array();//menyiapkan array/list
    
    //memasukkan anggota DPR ke list
    array_push($anggotaDpr, $anggota1);
    array_push($anggotaDpr, $anggota2);
    array_push($anggotaDpr, $anggota3);
    array_push($anggotaDpr, $anggota4);
    array_push($anggotaDpr, $anggota5);

    //Tampilkan Tabel
    //menyiapkan array 2d
    $listAnggota = array();
    $i = 0;
    foreach ($anggotaDpr as $anggota){
        $listAnggota[$i][0] = $anggota->getId();
        $listAnggota[$i][1] = $anggota->getName();
        $listAnggota[$i][2] = $anggota->getBidang();
        $listAnggota[$i][3] = $anggota->getPartai();
        $listAnggota[$i][4] = $anggota->getFoto();
        $i+=1;
    }

    //intansiasi tabel
    $tbl = new Tabel();
    
    //menyiapkan judul dan header tabel
    $judul = "Anggota DPR Inazuma";
    $head = array("Id", "Nama", "Bidang", "Partai", "Foto");
    
    //buat Tabel
    $tbl->buatTabel(sizeof($anggotaDpr), 5, $listAnggota, $head, $judul);
    
    
    // Perintah Ubah
    $diubahId = "035";  //Id anggota yang datanya akan diubah
    $ketemu = 0;
    foreach ($anggotaDpr as $anggota){
        //mencari anggota dengan Id
        if($anggota->getId() == $diubahId){
            //jika ketemu
            $anggota->setBidang("Budaya");
            $anggota->setFoto("<img src = '../foto/chiorin.jpg' widht = '35' height = 35");
            $ketemu = 1;

            echo "<br> <br>";
            echo " <i>" . " >> Data anggota DPR dengan Id <b> (" . $anggota->getId() . ") </b> telah diubah! << " . "</i>";
            echo "<br> <br>";
        }
    }

    //jika anggota yang dicari tidak ketemu
    if($ketemu == 0){
        echo "<br> <br>";
        echo " <i>" . " >> Data anggota DPR dengan Id <b> (" . $diubahId . ") </b> tidak ditemukan! << " . "</i>";
        echo "<br> <br>";
    }
    
    //tampilkan Tabel
    $i = 0;
    foreach ($anggotaDpr as $anggota){
        $listAnggota[$i][0] = $anggota->getId();
        $listAnggota[$i][1] = $anggota->getName();
        $listAnggota[$i][2] = $anggota->getBidang();
        $listAnggota[$i][3] = $anggota->getPartai();
        $listAnggota[$i][4] = $anggota->getFoto();
        $i+=1;
    }
    $tbl->buatTabel(sizeof($anggotaDpr), 5, $listAnggota, $head, $judul);
    

    // Hapus
    $ketemu = 0;
    $dihapusId = "051"; //Id anggota yang akan dihapus
    foreach ($anggotaDpr as $idx => $anggota){
        //mencari anggota
        if($anggota->getId() == $dihapusId){
            //ketemu
            unset($anggotaDpr[$idx]);
            $ketemu = 1;

            echo "<br> <br>";
            echo " <i>" . " >> Data anggota DPR dengan Id <b> (" . $anggota->getId() . ") </b> telah dihapus! << " . "</i>";
            echo "<br> <br>";
            
        }
    }

    //jika tidak ketemu
    if($ketemu == 0){
        echo "<br> <br>";
        echo " <i>" . " >> Data anggota DPR dengan Id <b> (" . $dihapusId . ") </b> tidak ditemukan! << " . "</i>";
        echo "<br> <br>";
    }
    
    //tampilkan Tabel
    $i = 0;
    foreach ($anggotaDpr as $anggota){
        $listAnggota[$i][0] = $anggota->getId();
        $listAnggota[$i][1] = $anggota->getName();
        $listAnggota[$i][2] = $anggota->getBidang();
        $listAnggota[$i][3] = $anggota->getPartai();
        $listAnggota[$i][4] = $anggota->getFoto();
        $i+=1;
    }
    $tbl->buatTabel(sizeof($anggotaDpr), 5, $listAnggota, $head, $judul);
    
    
    // Tambah
    //siapkan anggota baru
    $anggotaTambah = new Dpr("060", "Kuki Shinobu", "Luar Negeri", "PGAM", "<img src = '../foto/kukis.jpg' widht = '35' height = 35");
    //masukan ke array/list
    array_push($anggotaDpr, $anggotaTambah);
    
    echo "<br> <br>";
    echo " <i>" . " >> Data anggota DPR baru telah ditambahkan! << " . "</i>";
    echo "<br> <br>";
    
    //Tampilkan Tabel
    $i = 0;
    foreach ($anggotaDpr as $anggota){
        $listAnggota[$i][0] = $anggota->getId();
        $listAnggota[$i][1] = $anggota->getName();
        $listAnggota[$i][2] = $anggota->getBidang();
        $listAnggota[$i][3] = $anggota->getPartai();
        $listAnggota[$i][4] = $anggota->getFoto();
        $i+=1;
    }
    $tbl->buatTabel(sizeof($anggotaDpr), 5, $listAnggota, $head, $judul);


    
?>