public class Dpr{
    private String id;
    private String name;
    private String bidang;
    private String partai;

    public Dpr(){
        this.id = "";
        this.name = "";
        this.bidang = "";
        this.partai = "";
    }

    public Dpr(String id, String name, String bidang, String partai){
        this.name = id;
        this.name = name;
        this.name = bidang;
        this.name = partai;
    }

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getBidang(){
        return this.bidang;
    }

    public void setBidang(String bidang){
        this.bidang = bidang;
    }

    public String getPartai(){
        return this.partai;
    }

    public void setPartai(String partai){
        this.partai = partai;
    }

}