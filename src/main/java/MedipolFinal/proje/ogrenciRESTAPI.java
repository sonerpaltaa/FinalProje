package MedipolFinal.proje;
import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/ogrenci")

public class ogrenciRESTAPI {
	private static List<Ogrenci> ogrenciListesi = new ArrayList<Ogrenci>();
	static {
		ogrenciListesi.add(new Ogrenci("Soner",21));
		ogrenciListesi.add(new Ogrenci("Elif",25));
	}
	// ---------------------------------------
	public static class Ogrenci {
		private String isim;
		private int numara;
		public Ogrenci(String isim, int numara) {
			this.isim = isim;
			this.numara = numara;
		}
		public String getIsim() { return isim; }
		public int getNumara() { return numara; }
	}
	// ---------------------------------------
    @RequestMapping(path="/listele", method = RequestMethod.GET)
    public List<Ogrenci> listele() {
        return ogrenciListesi;
    }
    @RequestMapping(path="/ekle", method = RequestMethod.POST)
    public Ogrenci ekle(@RequestBody Ogrenci ogrenci) {
		ogrenciListesi.add(ogrenci);
        return ogrenci;
    }
}
