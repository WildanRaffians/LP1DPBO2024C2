# Kelas DPR
class Dpr:
    # Atribut
    __id = ""
    __name = ""
    __bidang = ""
    __partai = ""

    #constructor
    def __init__(self, id = "", name = "", bidang = "", partai = ""):
        self.__name = name
        self.__id = id
        self.__bidang = bidang
        self.__partai = partai

    #getter dan setter
    def get_name(self):
        return self.__name

    def set_name(self, name):
        self.__name = name

    def get_id(self):
        return self.__id
    
    def set_id(self, id):
        self.__id = id
  
    def get_bidang(self):
        return self.__bidang
    
    def set_bidang(self, bidang):
        self.__bidang = bidang

    def get_partai(self):
        return self.__partai
    
    def set_partai(self, partai):
        self.__partai = partai