class Tabel:
    __baris = 0
    __kolom = 0

    def __init__(self, baris = "", kolom = ""):
        self.__baris = baris
        self.__kolom = kolom


    def get_baris(self):
        return self.__baris
    
    def set_baris(self, baris):
        self.__baris = baris

    def get_kolom(self):
        return self.__kolom

    def set_kolom(self, kolom):
        self.__kolom = kolom


    def buat_tabel(self, n_baris, n_kolom, isiTabel, headTabel):
        maxPerKolom = [0, 0, 0, 0]
        for i in range(n_kolom):
            maxPerKolom[i] = len(headTabel[i])
            for j in range(n_baris):
                if(len(isiTabel[j][i]) > maxPerKolom[i]):
                    maxPerKolom[i] = len(isiTabel[j][i])
            maxPerKolom[i] += 1
        
        self.pemisah_baris(n_kolom, maxPerKolom, '=')

        for kolom in range(n_kolom):
            print("| " + headTabel[kolom], end = "")
            if(len(headTabel[kolom]) < maxPerKolom[kolom]):
                for spasi in range(maxPerKolom[kolom]-len(headTabel[kolom])):
                    print(" ", end = "")
            else:
                print("  ", end = "")
        print("|")

        self.pemisah_baris(n_kolom, maxPerKolom, '=')

        for baris in range(n_baris):
            for kolom in range(n_kolom):
                print("| " + isiTabel[baris][kolom], end = "")

                if(len(headTabel[kolom]) < maxPerKolom[kolom]):
                    for spasi in range(maxPerKolom[kolom]-len(isiTabel[baris][kolom])):
                        print(" ", end = "")
                else:
                    print("  ", end = "")
            print("|")
            self.pemisah_baris(n_kolom, maxPerKolom, '-')
                

    def pemisah_baris(self, n_kolom, maxPerKolom, simbol = ''):
        for kolom in range(n_kolom):
            for perkolom in range(maxPerKolom[kolom]):
                print(simbol, end='')
            print(simbol, end='')
            print(simbol, end='')
        print(simbol)