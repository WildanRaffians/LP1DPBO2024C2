<?php
//Kelas DPR
class Dpr {

    //atribut
    private $id = '';
    private $name = '';
    private $bidang = '';
    private $partai = '';
    private $foto = '';

    //constructor
    public function __construct($id = '', $name = '', $bidang = '', $partai = '', $foto = ''){
        $this->id = $id;
        $this->name = $name;
        $this->bidang = $bidang;
        $this->partai = $partai;
        $this->foto = $foto;
    }

    //setter dan getter
    public function setId($id){
        $this->id = $id;
    }

    public function getId(){
        return $this->id;
    }

    public function setName($name){
        $this->name = $name;
    }

    public function getName(){
        return $this->name;
    }
    public function setBidang($bidang){
        $this->bidang = $bidang;
    }

    public function getBidang(){
        return $this->bidang;
    }
    public function setPartai($partai){
        $this->partai = $partai;
    }

    public function getPartai(){
        return $this->partai;
    }
    public function setFoto($foto){
        $this->foto = $foto;
    }

    public function getFoto(){
        return $this->foto;
    }

}
?>