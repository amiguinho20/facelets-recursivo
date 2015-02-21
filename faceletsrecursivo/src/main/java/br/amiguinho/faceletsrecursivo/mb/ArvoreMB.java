package br.amiguinho.faceletsrecursivo.mb;

import java.io.Serializable;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.swing.tree.DefaultMutableTreeNode;

@Model
public class ArvoreMB implements Serializable{

	private static final long serialVersionUID = 8427751794991983183L;

	private DefaultMutableTreeNode arvore;
	
	public DefaultMutableTreeNode getArvore() {
		return arvore;
	}

	public void setArvore(DefaultMutableTreeNode arvore) {
		this.arvore = arvore;
	}

	@PostConstruct
	public void init()
	{
		DefaultMutableTreeNode sony    = new DefaultMutableTreeNode("Sony");
		DefaultMutableTreeNode bravia  = new DefaultMutableTreeNode("Bravia");
		DefaultMutableTreeNode walkman = new DefaultMutableTreeNode("Walkman");
		DefaultMutableTreeNode ps1     = new DefaultMutableTreeNode("PlayStation 1");
		DefaultMutableTreeNode mgs     = new DefaultMutableTreeNode("Metal Gear Solid");
		DefaultMutableTreeNode ffvii   = new DefaultMutableTreeNode("Final Fantasy VII");
		DefaultMutableTreeNode ps2     = new DefaultMutableTreeNode("PlayStation 2");
		DefaultMutableTreeNode gow     = new DefaultMutableTreeNode("God of War");
		DefaultMutableTreeNode ico     = new DefaultMutableTreeNode("Ico");
		
		sony.add(ps1);
		sony.add(ps2);
		sony.add(walkman);
		sony.add(bravia);
		
		ps1.add(mgs);
		ps1.add(ffvii);
		
		ps2.add(gow);
		ps2.add(ico);
		
		arvore = sony;
		
		imprimir(arvore);
		
		
	}
	
	private void imprimir(DefaultMutableTreeNode elemento)
	{
		String label = elemento.getUserObject().toString();
		int level = elemento.getLevel();
		String indentacao = "";
		for (int i = 0; i < level; i++)
		{
			indentacao += "----";
		}
		System.out.println(indentacao + " label: " + label);
		
		if (!elemento.isLeaf())
		{
			Enumeration enumeration = elemento.children();
			while (enumeration.hasMoreElements()) {
				DefaultMutableTreeNode elementoFilho =  
						(DefaultMutableTreeNode) enumeration.nextElement();
				//--recursividade
				imprimir(elementoFilho);
			}
		}
	}
	
	public List<DefaultMutableTreeNode> converterParaLista(DefaultMutableTreeNode elemento)
	{    
		List<DefaultMutableTreeNode> list = Collections.list(elemento.children());
		return list;
	}

}
