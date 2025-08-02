package com.CyberSoft.uniclubWeb.service;

import com.CyberSoft.uniclubWeb.entity.*;
import com.CyberSoft.uniclubWeb.repository.*;
import com.CyberSoft.uniclubWeb.service.imp.FakeDataServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class FakeDataService implements FakeDataServiceImp {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    private final Random random = new Random();

    @Override
    public void generateFakeData() {
        generateRoles(2);
        generateUsers(10);
        generateProducts(20);
        // Mở nếu cần:
        // generateReviews(10);
        // generateWishlists(10);
    }

    @Override
    public void generateRoles(int count) {
        for (int i = 1; i <= count; i++) {
            String roleName = switch (i) {
                case 1 -> "ROLE_ADMIN";
                default -> "ROLE_USER";
            };

            // Check trùng role name
            if (roleRepository.existsByName(roleName)) {
                System.out.println("Bỏ qua vai trò đã tồn tại: " + roleName);
                continue;
            }

            RoleEntity role = new RoleEntity();
            role.setName(roleName);
            roleRepository.save(role);
        }
    }

    @Override
    public void generateUsers(int count) {
        for (int i = 1; i <= count; i++) {
            String email = "user" + i + "@example.com";
            if (userRepository.existsByEmail(email)) {
                System.out.println("Bỏ qua vì trùng email: " + email);
                continue;
            }

            UserEntity user = new UserEntity();
            user.setFullName("User " + i);
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode("password" + i)); // nên mã hoá trong thực tế
            user.setRole(roleRepository.findById(1).orElse(null)); // ROLE_ADMIN giả định ID=1
            userRepository.save(user);
        }
    }

    @Override
    public void generateProducts(int count) {
    	LocalDateTime now = LocalDateTime.now();
        for (int i = 1; i <= count; i++) {
            String sku = "SKU" + i;
            if (productRepository.existsBySku(sku)) {
                System.out.println("Bỏ qua sản phẩm trùng SKU: " + sku);
                continue;
            }

            ProductEntity product = new ProductEntity();
            product.setProductName("Product " + i);
            product.setPrice(Double.valueOf(random.nextInt(1000) + 100)); // Từ 100 đến 1099
            product.setSku(sku);
            product.setStar(random.nextInt(6)); // 0–5
            product.setStatus("Active");
            product.setDescription("Mô tả cho Product " + i);
            product.setInformation("Thông tin kỹ thuật Product " + i);
            product.setImages("[\"image" + i + ".jpg\"]"); // định dạng JSON string
            product.setUpdatedAt(now);
            product.setCreatedAt(now);
            productRepository.save(product);
        }
    }

//	@Override
//	public void generateReviews(int count) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void generateWishlists(int count) {
//		// TODO Auto-generated method stub
//		
//	}
}
