package com.learn.entity;

        import java.io.Serializable;
        import java.util.Date;
        import com.learn.service.*;



/**
 * 课程信息
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date # 10:23:12
 */
public class CourseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

            //
                    private Long id;
        
            //名称
                    private String name;
        
            //介绍
                    private String content;
        
            //上课地点
                    private String area;
        
            //所需课时
                    private String keshi;
        
            //添加时间
                    private Date gmttime =new  Date();
        
    
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
         * 设置：名称
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * 获取：名称
         */
        public String getName() {
            return name;
        }
            /**
         * 设置：介绍
         */
        public void setContent(String content) {
            this.content = content;
        }

        /**
         * 获取：介绍
         */
        public String getContent() {
            return content;
        }
            /**
         * 设置：上课地点
         */
        public void setArea(String area) {
            this.area = area;
        }

        /**
         * 获取：上课地点
         */
        public String getArea() {
            return area;
        }
            /**
         * 设置：所需课时
         */
        public void setKeshi(String keshi) {
            this.keshi = keshi;
        }

        /**
         * 获取：所需课时
         */
        public String getKeshi() {
            return keshi;
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
