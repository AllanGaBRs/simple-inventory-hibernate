package UI;

import db.functions.CreateDB;
import model.Product;
import model.Supplier;
import service.ProductService;
import service.SupplierService;

import java.util.List;
import java.util.Scanner;

public class Menu {
    ProductService productService = new ProductService();
    SupplierService supplierService = new SupplierService();
    private final Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        int option = -1;
        do {
            try {
                System.out.println("\n==== MENU ====");
                System.out.println("1 - Cadastrar Fornecedor");
                System.out.println("2 - Cadastrar Produto");
                System.out.println("3 - Listar Fornecedores");
                System.out.println("4 - Listar Produtos");
                System.out.println("5 - Atualizar Produto");
                System.out.println("6 - Atualizar Fornecedor");
                System.out.println("7 - Excluir Produto");
                System.out.println("8 - Excluir Fornecedor");
                System.out.println("0 - Sair");
                System.out.print("Escolha: ");
                option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1 -> saveSupplier();
                    case 2 -> saveProduct();
                    case 3 -> listSuppliers();
                    case 4 -> listProducts();
                    case 5 -> updateProduct();
                    case 6 -> updateSupplier();
                    case 7 -> removeProduct();
                    case 8 -> removeSupplier();
                    case 0 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida.");
                }

            } catch (Exception e) {
                System.out.println("ERRO: " + e.getMessage() + " Tente novamente.");
            }
        } while (option != 0);

    }

    private void saveSupplier() {
        System.out.print("Nome do fornecedor: ");
        String name = scanner.nextLine();
        Supplier supplier = new Supplier();
        supplier.setName(name);
        supplierService.save(supplier);
        System.out.println("Fornecedor cadastrado com sucesso.");
    }

    private void saveProduct() {
        List<Supplier> suppliers = supplierService.listAll();

        if (suppliers.isEmpty()) {
            System.out.println("Nenhum fornecedor disponível. Cadastre um primeiro.");
            return;
        }

        System.out.println("Escolha um fornecedor:");
        for (int i = 0; i < suppliers.size(); i++) {
            System.out.println(i + " - " + suppliers.get(i).getName());
        }

        System.out.print("Digite o número do fornecedor: ");
        int pos = Integer.parseInt(scanner.nextLine());

        if (pos < 0 || pos >= suppliers.size()) {
            System.out.println("Fornecedor inválido.");
            return;
        }

        Supplier selectSupplier = suppliers.get(pos);

        System.out.print("Nome do produto: ");
        String productName = scanner.nextLine();

        System.out.print("Preço do produto: ");
        Double price = Double.parseDouble(scanner.nextLine());

        Product product = new Product();
        product.setName(productName);
        product.setPrice(price);
        product.setSupplier(selectSupplier);
        productService.save(product);
        System.out.println("Produto cadastrado com sucesso.");
    }

    private void listSuppliers() {
        List<Supplier> list = supplierService.listAll();

        System.out.println("\n=== FORNECEDORES ===");
        if (list.isEmpty()) {
            System.out.println("Nenhum fornecedor encontrado.");
        } else {
            list.forEach(s -> System.out.println("ID: " + s.getId() + " | Nome: " + s.getName()));
        }
    }

    private void listProducts() {
        List<Product> list = productService.listAll();

        System.out.println("\n=== PRODUTOS ===");
        if (list.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
        } else {
            list.forEach(p -> System.out.println("ID: " + p.getId() + " | Nome: " + p.getName() +
                    " | Preço: R$" + p.getPrice() + " | Fornecedor: " + p.getSupplier().getName()));
        }
    }

    private void updateProduct() {
        List<Product> list = productService.listAll();
        if (list.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
            return;
        }
        System.out.println("Qual produto deseja atualizar");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " - " + list.get(i).getName());
        }
        System.out.print("Digite o número do produto: ");
        int pos = Integer.parseInt(scanner.nextLine());

        if (pos < 0 || pos >= list.size()) {
            System.out.println("Produto inválido.");
            return;
        }

        Product selectProduct = list.get(pos);

        System.out.println("Qual vai ser o novo nome do produto " + selectProduct.getName() + "?");
        String newName = scanner.nextLine();
        productService.update(selectProduct.getName(), newName);
        System.out.println("Produto Atualizado com sucesso!!!");
    }

    private void updateSupplier() {
        List<Supplier> list = supplierService.listAll();
        if (list.isEmpty()) {
            System.out.println("Nenhum fornecedor encontrado.");
            return;
        }
        System.out.println("Qual fornecedor deseja atualizar");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " - " + list.get(i).getName());
        }
        System.out.print("Digite o número do fornecedor: ");
        int pos = Integer.parseInt(scanner.nextLine());

        if (pos < 0 || pos >= list.size()) {
            System.out.println("Forncedor inválido.");
            return;
        }

        Supplier selectSupplier = list.get(pos);

        System.out.println("Qual vai ser o novo nome do fornecedor " + selectSupplier.getName() + "?");
        String newName = scanner.nextLine();
        supplierService.update(selectSupplier.getName(), newName);
        System.out.println("Fornecedor Atualizado com sucesso!!!");
    }

    private void removeProduct() {
        List<Product> list = productService.listAll();
        if (list.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
            return;
        }
        System.out.println("Qual produto deseja excluir?");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " - " + list.get(i).getName());
        }
        System.out.print("Digite o número do produto: ");
        int pos = Integer.parseInt(scanner.nextLine());

        if (pos < 0 || pos >= list.size()) {
            System.out.println("Produto inválido.");
            return;
        }

        Product productSelect = list.get(pos);
        productService.remove(productSelect.getName());
        System.out.println("Produto Deletado com sucesso!!!");
    }

    private void removeSupplier() {
        List<Supplier> list = supplierService.listAll();
        if (list.isEmpty()) {
            System.out.println("Nenhum fornecedor encontrado.");
            return;
        }
        System.out.println("Qual fornecedor deseja excluir?");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " - " + list.get(i).getName());
        }
        System.out.print("Digite o número do fornecedor: ");
        int pos = Integer.parseInt(scanner.nextLine());

        if (pos < 0 || pos >= list.size()) {
            System.out.println("Fornecedor inválido.");
            return;
        }

        Supplier supplierSelect = list.get(pos);
        supplierService.remove(supplierSelect.getName());
        System.out.println("Fornecedor Deletado com sucesso!!!");
    }
}
