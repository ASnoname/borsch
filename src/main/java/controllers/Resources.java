package controllers;

class Resources {
  static final String ROOT_PREFIX = "/";
  static final String USER_PREFIX = "/user/";
  static final String FOOD_PREFIX = "/food/";
  static final String FRIDGE_PREFIX = "/id{idUser}/fridge/";
  static final String RECIPE_PREFIX = "/id{idUser}/recipe/";
  static final String PRODUCT_BY_RECIPE_PREFIX = "/id{idUser}/{idRecipe}/product/";

  static final String ADMIN_PREFIX = "/admin/";
  static final String ADMIN_FOOD_PREFIX = "/admin/food/";

  static final String SUCCESS_STATUS = "OK";
  static final String UNSUCCESS_STATUS = "NOT OK";
}