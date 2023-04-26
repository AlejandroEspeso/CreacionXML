import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class CreacionXMLcoche {

	public static void main(String[] args) throws ParserConfigurationException, IOException, TransformerException {
		
	Coche Coche1=new Coche("1","Ferrari","360 modena",1998,340,"cv",79500,"euro");
	Coche Coche2=new Coche("2","BMW","Serie 3",2005,180,"cv",18200,"euro");
	Coche Coche3=new Coche("3","Ford","Mustang",2011,520,"cv",100000,"euro");
	Coche Coche4=new Coche("4","Fiat","500",2018,120,"cv",21000,"euro");
	Coche Coche5=new Coche("5","Alfa Romeo","Giuletta",2015,150,"cv",25000,"euro");
	Coche[] coches= {Coche1,Coche2,Coche3,Coche4,Coche5};
	
	DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
	DocumentBuilder builder=factory.newDocumentBuilder();
	Document document=builder.newDocument();

	Element elementoCatalogoCoches=document.createElement("catalogoCoche");

	//Coche viene del arrays "Coche[] coches= {Coche1,Coche2,Coche3,Coche4,Coche5};"
	for(Coche l:coches) {
	
		//Elemento hijo de raiz
		Element elementoCoche=document.createElement("coche");
		
		//Elementos hijo de coche
		Element elementoMarca=document.createElement("marca");
		Element elementoModelo=document.createElement("modelo");
		Element elementoAnyo=document.createElement("año");
		Element elementoPotencia=document.createElement("potencia");
		Element elementoPrecio=document.createElement("precio");
	
		//Texto de los hijos de coche
		Text textoMarca=document.createTextNode(l.getMarca());
		Text textoModelo=document.createTextNode(l.getModelo());
		Text textoAnyo=document.createTextNode(l.getAnyo()+"");
		Text textoPotencia=document.createTextNode(l.getPotencia()+"");
		Text textoPrecio=document.createTextNode(l.getPrecio()+"");
		
		//Añadimos los textos a los elementos
		elementoMarca.appendChild(textoMarca);
		elementoModelo.appendChild(textoModelo);
		elementoAnyo.appendChild(textoAnyo);
		elementoPotencia.appendChild(textoPotencia);
		elementoPrecio.appendChild(textoPrecio);
		
		//Una vez hecho los elementos con su texto, haremos los atributos
		elementoPotencia.setAttribute("unidad", l.getAttUnidad());
		elementoPrecio.setAttribute("moneda", l.getAttMoneda());
		elementoCoche.setAttribute("id", l.getAttId());
		
		//Añado los elementos al elemento coche
		elementoCoche.appendChild(elementoMarca);
		elementoCoche.appendChild(elementoModelo);
		elementoCoche.appendChild(elementoAnyo);
		elementoCoche.appendChild(elementoPotencia);
		elementoCoche.appendChild(elementoPrecio);
		
		//Añadimos el elemento coche al elemento catalogoCoche
		elementoCatalogoCoches.appendChild(elementoCoche);
	}
	
	//Añadimos
	document.appendChild(elementoCatalogoCoches);
	
	//Alamacenamos el documento XML
	saveXMLtoFile(document,"catalogoCoches.xml");
	}
	
	
	public static void saveXMLtoFile(Document document,String fileName) throws IOException,TransformerException {
		
		DOMSource domSource=new DOMSource(document);
		FileWriter writer=new FileWriter("C:\\Users\\Alumno\\Desktop\\"+fileName);
		StreamResult result=new StreamResult(writer);
		TransformerFactory transformerFactory=TransformerFactory.newInstance();
		Transformer transformer=transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "8859-1");
		transformer.setOutputProperty(OutputKeys.INDENT,"yes");
		transformer.setOutputProperty(OutputKeys.STANDALONE,"yes");
		transformer.transform(domSource, result);		
		writer.close();	
	
}

}
