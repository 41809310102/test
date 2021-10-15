package com.learn.entity;

        import java.io.Serializable;
        import java.util.Date;
        import com.learn.service.*;



/**
 * 签到信息
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date # 10:23:12
 */
public class QianEntity implements Serializable {
    private static final long serialVersionUID = 1L;

            //
                    private Long id;
        
            //课程
                    private Long paike;
                    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private  PaikeEntity  paikeEntity;

            public PaikeEntity getPaikeEntity() {
                return paikeEntity;
            }

            public void setPaikeEntity(PaikeEntity paikeEntity) {
                this.paikeEntity = paikeEntity;
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

            private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
         * 设置：课程
         */
        public void setPaike(Long paike) {
            this.paike = paike;
        }

        /**
         * 获取：课程
         */
        public Long getPaike() {
            return paike;
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
