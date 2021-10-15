package com.learn.entity;

import java.io.Serializable;
import java.util.Date;

import com.learn.service.*;


/**
 * 课程安排
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date # 10:23:12
 */
public class PaikeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;

    //课程信息
    private Long course;

    private CourseEntity courseEntity;

    public CourseEntity getCourseEntity() {
        return courseEntity;
    }

    public void setCourseEntity(CourseEntity courseEntity) {
        this.courseEntity = courseEntity;
    }

    //上课时间
    private Date time;
    private Date end;

    //添加时间
    private Date gmttime = new Date();

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    /**
     * 设置：
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：课程信息
     */
    public void setCourse(Long course) {
        this.course = course;
    }

    /**
     * 获取：课程信息
     */
    public Long getCourse() {
        return course;
    }

    /**
     * 设置：上课时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取：上课时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置：添加时间
     */
    public void setGmttime(Date gmttime) {
        this.gmttime = gmttime;
    }

    /**
     * 获取：添加时间
     */
    public Date getGmttime() {
        return gmttime;
    }
}
