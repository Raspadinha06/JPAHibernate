package br.com.davi.loja.testes;

import br.com.davi.loja.dao.CategoriaDao;
import br.com.davi.loja.dao.ProdutoDao;
import br.com.davi.loja.modelo.Categoria;
import br.com.davi.loja.modelo.Produto;
import br.com.davi.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProdutos {
    public static void main(String[] args) {
        cadastrarProduto();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto p1 = produtoDao.buscarPorId(1l);
        System.out.println(p1.getPreco());

        List<Produto> todos = produtoDao.buscarPorNomeDaCategoria("CELULARES");
        todos.forEach(p2 -> System.out.println(p2.getNome()));

        BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoPorNome("Xiaomi Redmi Note 8");
        System.out.println(precoDoProduto);
    }

    private static void cadastrarProduto(){
        Categoria celulares = new Categoria("CELULARES");

        Produto celular = new Produto("Xiaomi Redmi Note 8", "Custo benefício",
                new BigDecimal("1000"), celulares);

        EntityManager em = JPAUtil.getEntityManager();

        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();
        categoriaDao.cadastrar(celulares);

        produtoDao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }
}
