package NodeData;

public class NodeBuku {
    public int kodeBuku;
    public String judulBuku;
    public String pengarang;
    public int tahunTerbit;
    public int stok;

    public NodeBuku(int kodeBuku,String judul,String pengarang, int tahun, int stok){
        this.kodeBuku = kodeBuku;
        this.judulBuku = judul;
        this.pengarang = pengarang;
        this.tahunTerbit = tahun;
        this.stok = stok;
    }
}
