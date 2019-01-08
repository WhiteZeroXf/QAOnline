package com.zero.qsonline.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.ParameterizedType;

/**
 * * @author 郝雪峰 E-mail:xuefeng.hao@ambow.com
 *
 * @version V1.0
 * @date 创建时间：2018/11/14 11:09
 */
@SuppressWarnings({"unchecked"})
public abstract class BaseController<T> {

    /**
     * 与 T 相对应的 Service
     *
     * @return 相对应的 Service
     */
    protected abstract IService service();

    private Class modelClass;
    private String modelName;

    protected BaseController() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
        this.modelName = modelClass.getSimpleName();
    }

    /**
     * 删除数据
     *
     * @return 删除成功/失败
     */
    @DeleteMapping(value = "json/delete")
    public ResponseBean delete(String id) {
        service().removeById(id);
        return ResponseBean.OK.data("删除成功");
    }

    /**
     * 获取全部数据
     *
     * @return 全部数据列表
     */
    @GetMapping(value = "json/all")
    public ResponseBean listAll() {
        return ResponseBean.OK.data(service().list(new QueryWrapper<T>()));
    }

    /**
     * 新增一条数据
     *
     * @param entity 新增实体
     * @return 新增成功/失败
     */
    @PostMapping(value = "json/add")
    public ResponseBean save(@RequestBody T entity) {
        service().save(entity);
        return ResponseBean.OK.data("新增成功");
    }


}
