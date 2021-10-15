package com.learn.entity;

        import java.io.Serializable;
        import java.util.Date;
        import com.learn.service.*;



/**
 * 学生课程
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date # 10:23:12
 */
public class StucourseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

            //
                    private Long id;
        
            //课程信息
                    private Long course;

            private  CourseEntity  courseEntity;

            public CourseEntity getCourseEntity() {
                return courseEntity;
            }

            public void setCourseEntity(CourseEntity courseEntity) {
                this.courseEntity = courseEntity;
            }
        
            //学生
                    private Long user;

            private SysUserEntity sysUserEntity;

            public SysUserEntity getSysUserEntity() {
                return sysUserEntity;
            }

            public void setSysUserEntity(SysUserEntity sysUserEntity) {
                this.sysUserEntity = sysUserEntity;
            }

        
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
         * 设置：学生
         */
        public void setUser(Long user) {
            this.user = user;
        }

        /**
         * 获取：学生
         */
        public Long getUser() {
            return user;
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
