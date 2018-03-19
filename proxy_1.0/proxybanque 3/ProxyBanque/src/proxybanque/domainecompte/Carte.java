package proxybanque.domainecompte;

public class Carte {
private CCourant compteCourant;
private TypeCarte type;

public Carte(TypeCarte type) {
	this.type = type;
}
public CCourant getCompteCourant() {
	return compteCourant;
}
public void setCompteCourant(CCourant compteCourant) {
	this.compteCourant = compteCourant;
}
public TypeCarte getType() {
	return type;
}
public void setType(TypeCarte type) {
	this.type = type;
}

}
