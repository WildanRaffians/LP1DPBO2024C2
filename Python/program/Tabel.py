# Kelas Tabel
class Tabel:
    # Atribut
    __baris = 0
    __kolom = 0

    # Constructor
    def __init__(self, baris = "", kolom = ""):
        self.__baris = baris
        self.__kolom = kolom

    # Setter dan Getter
    def get_baris(self):
        return self.__baris
    
    def set_baris(self, baris):
        self.__baris = baris

    def get_kolom(self):
        return self.__kolom

    def set_kolom(self, kolom):
        self.__kolom = kolom

    # Method membuat tabel
    def buat_tabel(self, n_baris, n_kolom, isiTabel, headTabel):
        maxPerKolom = [0, 0, 0, 0]  #Menampung max tiap kolom

        # Mencari maxperkolom
        for kolom in range(n_kolom):
            maxPerKolom[kolom] = len(headTabel[kolom])
            for baris in range(n_baris):
                if(len(isiTabel[baris][kolom]) > maxPerKolom[kolom]):
                    maxPerKolom[kolom] = len(isiTabel[baris][kolom])
            maxPerKolom[kolom] += 1
        
        # buat garis pemisah baris
        self.pemisah_baris(n_kolom, maxPerKolom, '=')

        #Header tabel
        for kolom in range(n_kolom):
            print("| " + headTabel[kolom], end = "")
            if(len(headTabel[kolom]) < maxPerKolom[kolom]):
                for spasi in range(maxPerKolom[kolom]-len(headTabel[kolom])):
                    print(" ", end = "")
            else:
                print("  ", end = "")
        print("|")

        # buat garis pemisah baris
        self.pemisah_baris(n_kolom, maxPerKolom, '=')

        #isi tabel
        for baris in range(n_baris):
            for kolom in range(n_kolom):
                print("| " + isiTabel[baris][kolom], end = "")

                if(len(headTabel[kolom]) < maxPerKolom[kolom]):
                    for spasi in range(maxPerKolom[kolom]-len(isiTabel[baris][kolom])):
                        print(" ", end = "")
                else:
                    print("  ", end = "")
            print("|")
            # buat garis pemisah baris
            self.pemisah_baris(n_kolom, maxPerKolom, '-')
                
    #Method membuat garis pemisah baris
    def pemisah_baris(self, n_kolom, maxPerKolom, simbol = ''):
        for kolom in range(n_kolom):
            for perkolom in range(maxPerKolom[kolom]):
                print(simbol, end='')
            print(simbol, end='')
            print(simbol, end='')
        print(simbol)