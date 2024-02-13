//Kelas Tabel
public class Tabel{

    //Atribut
    private int baris;
    private int kolom;

    //Constructor
    public Tabel(){
    }
    
    //Constructor
    public Tabel(int baris, int kolom){
        this.baris = baris;
        this.kolom = kolom;
    }

    //Setter dan Getter
    public int getBaris(){
        return this.baris;
    }

    public void setBaris(int baris) {
        this.baris = baris;
    }
    
    public int getKolom(){
        return this.kolom;
    }
    
    public void setKolom(int kolom) {
        this.kolom = kolom;
    }

    //method membuat tabel
    public void buatTabel(int n_baris, int n_kolom, String[][] isiTabel,String[] headTabel){
        int kolom=0, baris=0;
        int maxPerKolom[] = new int[n_kolom];   //array of int menampung max char per kolom nya

        //mencari maxperkolom
        for(kolom = 0; kolom < n_kolom; kolom++){
            maxPerKolom[kolom] = headTabel[kolom].length();
            for(baris = 0; baris < n_baris; baris++){
                if(isiTabel[baris][kolom].length() > maxPerKolom[kolom]){
                    maxPerKolom[kolom] = isiTabel[baris][kolom].length();
                }
            }
            maxPerKolom[kolom]+=1;
        }

        //buat garis
        pemisahBaris(n_kolom, maxPerKolom, '-');
        
        //header tabel
        for(kolom = 0; kolom < n_kolom; kolom++){
            System.out.print("| " + headTabel[kolom]);
            if(headTabel[kolom].length() < maxPerKolom[kolom]){
                for(int spasi = 0; spasi < maxPerKolom[kolom]-headTabel[kolom].length(); spasi++){
                    System.out.print(" ");
                }
            } else{
                System.out.print("  ");
            }
            
        }
        System.out.println("|");

        //buat garis
        pemisahBaris(n_kolom, maxPerKolom, '=');
        
        //isi tabel
        for(baris = 0; baris < n_baris; baris++){
            for(kolom = 0; kolom < n_kolom; kolom++){
                System.out.print("| " + isiTabel[baris][kolom]);
                
                if(headTabel[kolom].length() < maxPerKolom[kolom]){
                    for(int spasi = 0; spasi < maxPerKolom[kolom]-isiTabel[baris][kolom].length(); spasi++){
                        System.out.print(" ");
                    }
                } else{
                    System.out.print(" ");
                }
                
            }
            System.out.println("|");
            //buat garis
            pemisahBaris(n_kolom, maxPerKolom, '-');
        }
    }
    
    //method untuk garis pemisah baris
    public void pemisahBaris(int n_kolom, int maxPerKolom[], char simbol){
        for(int kolom = 0; kolom < n_kolom; kolom++){
            for(int perKolom = 0; perKolom < maxPerKolom[kolom]; perKolom++){
                System.out.print(simbol);
            }
            System.out.print(simbol);
            System.out.print(simbol);

        }
        System.out.println(simbol);
    }
    
}