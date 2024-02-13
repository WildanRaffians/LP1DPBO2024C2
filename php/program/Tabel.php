<?php
//Kelas Tabel
class Tabel {

    //Atribut
    private $baris = ''; 
    private $kolom = '';

    //Contructor
    public function __construct($baris = '', $kolom = ''){
        $this->baris = $baris;
        $this->kolom = $kolom;
    }

    //Setter dan Getter
    public function setBaris($baris){
        $this->baris = $baris;
    }

    public function getBaris(){
        return $this->baris;
    }

    public function setKolom($kolom){
        $this->kolom = $kolom;
    }

    public function getKolom(){
        return $this->kolom;
    }

    //Method membuat Tabel
    public function buatTabel($n_baris, $n_kolom, $isiTabel, $headTabel, $judul){

        echo "<table border='1' style='border-collapse: collapse;'>";
        echo "<caption style='caption-side: top; text-align: center; font-weight: bold; padding: 10px; font-size: 24px;'>" . $judul . "</caption>";
        echo "<tr>";
        for($kolom = 0; $kolom < $n_kolom; $kolom++){
            echo "<th style='padding: 8px;'>" . $headTabel[$kolom] . "</th>";
        }
        echo "</tr>";
        
        for($baris = 0; $baris < $n_baris; $baris++){
            echo "<tr>";
            for($kolom = 0; $kolom < $n_kolom; $kolom++){
                echo "<td style='padding: 8px;'>" . $isiTabel[$baris][$kolom] . "</td>";
            }
        }
        echo "</table>";
    }
}
?>