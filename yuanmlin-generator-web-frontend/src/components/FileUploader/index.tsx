import { InboxOutlined } from '@ant-design/icons';
import React, { useState } from 'react';
import {message, UploadFile, UploadProps} from 'antd';
import Dragger from 'antd/es/upload/Dragger';
import {uploadFileUsingPost} from "@/services/backend/fileController";

// eslint-disable-next-line @typescript-eslint/no-unused-vars
interface Props {
  biz: string;
  onChange?: (fileList: UploadFile[]) => void;
  value?: UploadFile[];
  description?: string;
}

/**
 * 文件上传组件
 * @param props
 * @constructor
 */
const FileUploader: React.FC<Props> = (props) => {
  // @ts-ignore
  const { biz, value, description, onChange } = props;
  const [loading, setLoading] = useState<boolean>(false);

  const uploadProps: UploadProps = {
    name: 'file',
    listType: 'text',
    multiple: false,
    maxCount: 1,
    fileList: value,
    disabled: loading,
    onChange: ({ fileList }) => {
      onChange?.(fileList);
    },
    customRequest: async (fileObj: any) => {
      setLoading(true);
      try {
        const res = await uploadFileUsingPost(
          {
            biz,
          },
          {},
          fileObj.file,
        );
        fileObj.onSuccess(res.data);
      } catch (e: any) {
        message.error('上传失败，' + e.message);
        fileObj.onError(e);
      }
      setLoading(false);
    }
  }
  return (
    <Dragger {...uploadProps}>
      <p className={'ant-upload-drag-icon'}>
        <InboxOutlined />
      </p>
      <p className={'ant-upload-text'}>点击或拖拽文件上传</p>
      <p className={'ant-upload-hit'}>{description}</p>
    </Dragger>
  );
};
export default FileUploader;
