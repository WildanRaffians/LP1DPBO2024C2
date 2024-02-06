//import library
#include <iostream>
#include <string>

//using standar namespace
using namespace std;

class Dpr{ //class dpr

    //Private attributes
    private:
        string id;      //id anggota
        string name;    //nama anggota
        string bidang;  //nama bidang anggota
        string partai;  //nama partai anggota

    //public methods
    public:

        //constractor
        Dpr(){
            //mengisi dengan nilai default
            this->id = "";
            this->name = "";
            this->bidang = "";
            this->partai = "";
        }

        //constractor dengan parameter
        Dpr(string id, string name, string bidang, string partai){
            //mengisi nilai atribut dari object dengan nilai dari parameter
            this->id = id;
            this->name = name;
            this->bidang = bidang;
            this->partai = partai;
        }

        //getter dan setter semua atribut

        string get_name(){
            return this->name;
        }

        void set_name(string name){
            this->name = name;
        }

        string get_id(){
            return this->id;
        }

        void set_id(string id){
            this->id = id;
        }
        
        string get_bidang(){
            return this->bidang;
        }

        void set_bidang(string bidang){
            this->bidang = bidang;
        }

        string get_partai(){
            return this->partai;
        }

        void set_partai(string partai){
            this->partai = partai;
        }

        //destractor
        ~Dpr(){
            
        }
};