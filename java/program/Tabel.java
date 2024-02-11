public class Tabel{
    private int baris;
    private int kolom;

    public Tabel(){
    }

    public Tabel(int baris, int kolom){
        this.baris = baris;
        this.kolom = kolom;
    }

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

    public void buatTabel(int n_baris, int n_kolom, String[][] isiTabel,String[] headTabel){
        int kolom, baris;
        int maxPerKolom[] = new int[n_kolom];

        for(int i = 0; i < n_kolom; i++){
            maxPerKolom[i] = headTabel[i].length();
            for(int j = 0; j < n_baris; j++){
                if(isiTabel[j][i].length() > maxPerKolom[i]){
                    maxPerKolom[i] = isiTabel[j][i].length();
                }
            }
            maxPerKolom[i]+=1;
        }

        pemisahBaris(n_kolom, maxPerKolom, '-');
        
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

        pemisahBaris(n_kolom, maxPerKolom, '=');
        
        
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
            pemisahBaris(n_kolom, maxPerKolom, '-');
        }
    }
    
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