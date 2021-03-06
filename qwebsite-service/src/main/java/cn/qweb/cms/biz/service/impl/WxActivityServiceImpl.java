package cn.qweb.cms.biz.service.impl;

import cn.qweb.cms.biz.domain.WxActivityDO;
import cn.qweb.cms.biz.domain.WxActivityMapper;
import cn.qweb.cms.biz.service.WxActivityService;
import cn.qweb.cms.biz.service.bo.WxActivityRemoveBO;
import cn.qweb.cms.biz.service.bo.WxActivitySaveBO;
import cn.qweb.cms.biz.service.bo.WxActivityUpdateBO;
import cn.qweb.cms.biz.service.dto.LessonNumberDTO;
import cn.qweb.cms.biz.service.dto.WxActivityDTO;
import cn.qweb.cms.biz.service.query.WxActivityQUERY;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.BeanPropertiesUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/*
 *  Created by xuebj - 2017/05/03.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class WxActivityServiceImpl implements WxActivityService {

    @Autowired
    private WxActivityMapper wxActivityMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public WxActivityDTO get(Long id){
        return BeanPropertiesUtils.copyProperties(wxActivityMapper.get(id),WxActivityDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<WxActivityDTO> list(WxActivityQUERY bean){
        PageHelper.startPage(bean.getPage(),bean.getPageSize());
        Page<WxActivityDO> wxActivity = (Page<WxActivityDO>) wxActivityMapper.listByQuery(bean);
        Pagination<WxActivityDTO> result = new Pagination<>();
        result.setData(BeanPropertiesUtils.covert2List(wxActivity, WxActivityDTO.class));
        result.setTotal(wxActivity.getTotal());
        return result;
    }

    @Override
    public LessonNumberDTO queryNumber(WxActivityQUERY bean) {
        PageHelper.startPage(1, 1);
        WxActivityDO lessonDO = new WxActivityDO();
        lessonDO.setTeacherId(bean.getTeacherId());
        LessonNumberDTO dto = new LessonNumberDTO();
        Page<WxActivityDO> lesson = (Page<WxActivityDO>) wxActivityMapper.list(lessonDO);
        dto.setTotal(lesson.getTotal());
        lessonDO.setStatus("1");
        PageHelper.startPage(1, 1);
        lesson = (Page<WxActivityDO>) wxActivityMapper.list(lessonDO);
        dto.setPendingCheck(lesson.getTotal());
        lessonDO.setStatus("2");
        PageHelper.startPage(1, 1);
        lesson = (Page<WxActivityDO>) wxActivityMapper.list(lessonDO);
        dto.setNotPass(lesson.getTotal());
        lessonDO.setStatus("3");
        PageHelper.startPage(1, 1);
        lesson = (Page<WxActivityDO>) wxActivityMapper.list(lessonDO);
        dto.setPass(lesson.getTotal());
        lessonDO.setStatus("4");
        PageHelper.startPage(1, 1);
        lesson = (Page<WxActivityDO>) wxActivityMapper.list(lessonDO);
        dto.setOnline(lesson.getTotal());
        lessonDO.setStatus("5");
        PageHelper.startPage(1, 1);
        lesson = (Page<WxActivityDO>) wxActivityMapper.list(lessonDO);
        dto.setUnderline(lesson.getTotal());
        return dto;
    }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(WxActivitySaveBO bean){
        WxActivityDO wxActivity = BeanPropertiesUtils.copyProperties(bean, WxActivityDO.class);
        wxActivity.setGmtCreate(new Date());
        wxActivityMapper.save(wxActivity);
        return wxActivity.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(WxActivityUpdateBO bean){
        WxActivityDO wxActivity = BeanPropertiesUtils.copyProperties(bean, WxActivityDO.class);
        wxActivity.setGmtModified(new Date());
        return wxActivityMapper.update(wxActivity);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(WxActivityRemoveBO bean){
        WxActivityDO wxActivity = BeanPropertiesUtils.copyProperties(bean, WxActivityDO.class);
        return wxActivityMapper.remove(wxActivity);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return wxActivityMapper.delete(id);
        }
}
