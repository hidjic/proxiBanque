package proxybanque.domainecompte;

public enum TypeCarte {
ELECTRON ("Visa Electron"),
PREMIER("Visa Premier");

private String name ="";

private TypeCarte(String name) {
	this.name = name;
}
public String toString() {
	return name;
}
}
