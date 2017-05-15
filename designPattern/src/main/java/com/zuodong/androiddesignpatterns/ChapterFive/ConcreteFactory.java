package com.zuodong.androiddesignpatterns.ChapterFive;

/**
 * Created by dongdong on 2017/2/21.
 */

public class ConcreteFactory extends Factory {


    /**
     * 通过反射来获取类的实例
     *
     * @param clz 产品对象类类型
     * @param <T>
     * @return
     */
    @Override
    public <T extends Product> T createProduct(Class<T> clz) {
        Product product = null;
        try {
            product = (Product) Class.forName(clz.getName()).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return (T) product;
    }

    /*如果工厂类只有一种的话，则可以直接使用静态方法来实现*/
//    Factory.createProductor(ConcreteProductor.class).method();
}
