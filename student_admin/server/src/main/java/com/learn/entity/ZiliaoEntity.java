package com.learn.entity;

        import java.io.Serializable;
        import java.util.Date;
        import com.learn.service.*;



/**
 * 教学资料
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date # 10:23:12
 */
public class ZiliaoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

            //
                    private Long id;
        
            //名称
                    private String name;
        
            //介绍
                    private String content;
        
            //文件
                    private String url;
        
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
         * 设置：文件
         */
        public void setUrl(String url) {
            this.url = url;
        }

        /**
         * 获取：文件
         */
        public String getUrl() {
            return url;
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
