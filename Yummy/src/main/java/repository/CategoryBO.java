/**
*Project name: ShopBanHang
*Version : 1.0
*Created date : 12 thg 3, 2019
*Description: Create by MyPC
*Copyright (c) 2019 by TeddyShoes. All rights reserved.
*/
package repository;

import java.util.ArrayList;

import dao.CategoryDAO;
import model.Category;

/**
 * @author MyPC
 *
 */
public class CategoryBO {
	// gọi lại hàm DAO
	CategoryDAO s = new CategoryDAO();

	// hàm get hiển thị ra LOẠI sản phẩm giao diện Trang chủ và Quản lý
	public ArrayList<Category> getListCategory() {
		return s.getListCategory();
	}

	// thêm mới 1 loại sản phẩm
	public boolean addCategory(Category ca) {
		return s.addCategory(ca);
	}

	// hàm get hiển thị ra loại sản phẩm theo mã id-
	public Category getCategoryByID(long id) {
		return s.getCategoryByID(id);
	}

	// sửa loại sản phẩm
	public boolean editCategory(Category ca) {
		return s.editCategory(ca);
	}

	// xóa loại sản phẩm theo mã id
	public int deleteCategory(long id) {
		return s.deleteProduct(id);
	}

}
