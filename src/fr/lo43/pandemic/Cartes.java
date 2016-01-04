import java.util.Vector;
public class Cartes {
	private Vector<Object> Deck;
	private Vector<Object> Defausse;
	public Cartes() {
		Deck = new Vector<Object>();
		Defausse = new Vector<Object>();
		Deck.setSize(0);
		Defausse.setSize(0);
	}
	public Object piocher_dessus(){
		if(!Deck.isEmpty()){
			Object c = new Object();
			c = Deck.firstElement();
			Deck.remove(0);
			return c;
		}
		return null;
	}
	public Object piocher_dessous(){
		if (!Deck.isEmpty()){
			Object c = new Object();
			c = Deck.lastElement();
			Deck.removeElementAt(Deck.size()-1);
			return c;
		}
		return null;
	}
	public void add_carte(Object c){
		Deck.addElement(c);
	}
	public void defausser(Object o){
		Defausse.addElement(o);
	}
	public int get_sizeDeck(){
		return Deck.size();
	}
	public int get_sizeDefausse(){
		return Defausse.size();
	}
	public void add_carte(int i, Object o){
		Deck.add(i, o);
	}
	/*public Object regardepremsElem(){
		return Deck.firstElement();
	}*/
	/*public Vector<Object> pop6Carte(){
		Vector<Object> tmp = new Vector<Object>();
		for(int i = 0;i<6;i++){
			if(!this.Pile.isEmpty()){
				tmp.addElement(this.piocher_dessus());
			}
		}
		return tmp;
	}
	public void push6Carte(Vector<Object> v){
		for(int i = 0; i<6 ; i++){
			if(!v.isEmpty()){
				this.Pile.add(0, v.firstElement());
				v.remove(0);
			}
		}
	}
	public Vector<Object> trier6Carte(Vector<Object> v, int tab[]){
		Vector<Object> f = new Vector<Object>();
		for(int i = 0; i < 6; i++){
			f.addElement(v.elementAt(tab[i]));
		}
		return f;
	}*/
}
