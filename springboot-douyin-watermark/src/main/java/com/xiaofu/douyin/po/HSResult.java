package com.xiaofu.douyin.po;

/**
 * @Author: xiaofu
 * @Description:
 */
public class HSResult {


    /**
     * status_code : 0
     * data : {"user_info":{"encrypted_id":"MS4wLjABAAAA0UiQZpx11fVgiuLDSfu6AIbZxKFGV-CHMRVkbQ7j79EbSA2VCNNN27eMEhKZlcHA"},"item_info":{"item_id":"6873627998554164487","cover":"http://p3-hs.byteimg.com/img/tos-cn-p-0015/4fd65019dce04fa6b2dde20d2a08248f~tplv-hs-large.jpg","url":"https://api.huoshan.com/hotsoon/item/video/_reflow/?video_id=v0200c3e0000bti0gft6aoef18eb3k0g&line=0&app_id=0&vquality=normal&watermark=2&long_video=0&sf=5&ts=1600676390&item_id=6873627998554164487"}}
     */

    private int status_code;
    private DataBean data;

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * user_info : {"encrypted_id":"MS4wLjABAAAA0UiQZpx11fVgiuLDSfu6AIbZxKFGV-CHMRVkbQ7j79EbSA2VCNNN27eMEhKZlcHA"}
         * item_info : {"item_id":"6873627998554164487","cover":"http://p3-hs.byteimg.com/img/tos-cn-p-0015/4fd65019dce04fa6b2dde20d2a08248f~tplv-hs-large.jpg","url":"https://api.huoshan.com/hotsoon/item/video/_reflow/?video_id=v0200c3e0000bti0gft6aoef18eb3k0g&line=0&app_id=0&vquality=normal&watermark=2&long_video=0&sf=5&ts=1600676390&item_id=6873627998554164487"}
         */

        private UserInfoBean user_info;
        private ItemInfoBean item_info;

        public UserInfoBean getUser_info() {
            return user_info;
        }

        public void setUser_info(UserInfoBean user_info) {
            this.user_info = user_info;
        }

        public ItemInfoBean getItem_info() {
            return item_info;
        }

        public void setItem_info(ItemInfoBean item_info) {
            this.item_info = item_info;
        }

        public static class UserInfoBean {
            /**
             * encrypted_id : MS4wLjABAAAA0UiQZpx11fVgiuLDSfu6AIbZxKFGV-CHMRVkbQ7j79EbSA2VCNNN27eMEhKZlcHA
             */

            private String encrypted_id;

            public String getEncrypted_id() {
                return encrypted_id;
            }

            public void setEncrypted_id(String encrypted_id) {
                this.encrypted_id = encrypted_id;
            }
        }

        public static class ItemInfoBean {
            /**
             * item_id : 6873627998554164487
             * cover : http://p3-hs.byteimg.com/img/tos-cn-p-0015/4fd65019dce04fa6b2dde20d2a08248f~tplv-hs-large.jpg
             * url : https://api.huoshan.com/hotsoon/item/video/_reflow/?video_id=v0200c3e0000bti0gft6aoef18eb3k0g&line=0&app_id=0&vquality=normal&watermark=2&long_video=0&sf=5&ts=1600676390&item_id=6873627998554164487
             */

            private String item_id;
            private String cover;
            private String url;

            public String getItem_id() {
                return item_id;
            }

            public void setItem_id(String item_id) {
                this.item_id = item_id;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
