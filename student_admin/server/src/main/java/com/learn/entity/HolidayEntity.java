package com.learn.entity;

        import java.io.Serializable;
        import java.util.Date;
        import com.learn.service.*;



/**
 * 请假信息
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date # 14:18:29
 */
public class HolidayEntity implements Serializable {
    private static final long serialVersionUID = 1L;

            //
                    private Long id;
        
            //课程
                    private Long paike;

            private  PaikeEntity  paikeEntity;

            public PaikeEntity getPaikeEntity() {
                return paikeEntity;
            }

            public void setPaikeEntity(PaikeEntity paikeEntity) {
                this.paikeEntity = paikeEntity;
            }
        
            //请假人
                    private Long user;

            private SysUserEntity sysUserEntity;

            public SysUserEntity getSysUserEntity() {
                return sysUserEntity;
            }

            public void setSysUserEntity(SysUserEntity sysUserEntity) {
                this.sysUserEntity = sysUserEntity;
            }

        
            //类型
                    private String type;
        
            //原因
                    private String reason;
        
            //审批结果
                    private String state;
        
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
         * 设置：请假人
         */
        public void setUser(Long user) {
            this.user = user;
        }

        /**
         * 获取：请假人
         */
        public Long getUser() {
            return user;
        }
            /**
         * 设置：类型
         */
        public void setType(String type) {
            this.type = type;
        }

        /**
         * 获取：类型
         */
        public String getType() {
            return type;
        }
            /**
         * 设置：原因
         */
        public void setReason(String reason) {
            this.reason = reason;
        }

        /**
         * 获取：原因
         */
        public String getReason() {
            return reason;
        }
            /**
         * 设置：审批结果
         */
        public void setState(String state) {
            this.state = state;
        }

        /**
         * 获取：审批结果
         */
        public String getState() {
            return state;
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
