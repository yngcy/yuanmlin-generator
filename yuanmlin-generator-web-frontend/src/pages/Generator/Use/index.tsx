import { COS_HOST } from '@/constants';
import AuthorInfo from '@/pages/Generator/Detail/compoents/AuthorInfo';
import FileConfig from '@/pages/Generator/Detail/compoents/FileConfig';
import ModelConfig from '@/pages/Generator/Detail/compoents/ModelConfig';
import {
  downloadGeneratorByIdUsingGet,
  getGeneratorVoByIdUsingGet, useGeneratorUsingPost,
} from '@/services/backend/generatorController';
import { Link, useModel, useParams } from '@@/exports';
import { DownloadOutlined, EditOutlined } from '@ant-design/icons';
import { PageContainer } from '@ant-design/pro-components';
import {
  Button,
  Card,
  Col,
  Collapse,
  Divider,
  Form,
  Image,
  Input,
  message,
  Row,
  Space,
  Tabs,
  Tag,
  Typography
} from 'antd';
import { saveAs } from 'file-saver';
import moment from 'moment';
import React, { useEffect, useState } from 'react';

/**
 * 生成器详情页页面
 * @constructor
 */
const GeneratorDetail: React.FC = () => {
  const { id } = useParams();
  const [form] = Form.useForm();

  const [loading, setLoading] = useState<boolean>(false);
  const [data, setData] = useState<API.GeneratorVO>({});
  const { initialState } = useModel('@@initialState');
  const { currentUser } = initialState ?? {};
  const [downloading, setDownloading] = useState<boolean>(false);

  const models = data?.modelConfig?.models ?? [];

  /**
   * 加载数据
   */
  const loadData = async () => {
    if (!id) {
      return;
    }
    setLoading(true);
    try {
      // @ts-ignore
      const res = await getGeneratorVoByIdUsingGet({ id });
      setData(res.data || {});
    } catch (error: any) {
      message.error('加载数据失败' + error.message);
    }
    setLoading(false);
  };

  useEffect(() => {
    loadData();
  }, [id]);

  /**
   * 标签列表
   * @param tags
   */
  const tagListView = (tags?: string[]) => {
    if (!tags) {
      return <></>;
    }
    return (
      <div style={{ marginBottom: 8 }}>
        {tags.map((tag: string) => (
          <Tag key={tag}>{tag}</Tag>
        ))}
      </div>
    );
  };

  /**
   * 生成按钮
   */
  const downloadButton = data.distPath && currentUser && (
    <Button
      type={'primary'}
      icon={<DownloadOutlined />}
      loading={downloading}
      onClick={async () => {
        setDownloading(true);
        const values = form.getFieldsValue();
        // eslint-disable-next-line react-hooks/rules-of-hooks
        const blob = await useGeneratorUsingPost(
          {
            id: data.id,
            dataModel: values,
          },
          {
            responseType: 'blob',
          },
        );
        const fullPath = data.distPath || '';
        saveAs(blob, fullPath.substring(fullPath.lastIndexOf('/') + 1));
        setDownloading(false);
      }}
    >
      生成代码
    </Button>
  );

  return (
    <PageContainer title={<></>} loading={loading}>
      <Card>
        <Row justify={'space-between'} gutter={[32, 32]}>
          <Col flex={'auto'}>
            <Space size={'large'} align={'center'}>
              <Typography.Title level={4}>{data.name}</Typography.Title>
              {tagListView(data.tags)}
            </Space>
            <Typography.Paragraph>{data.description}</Typography.Paragraph>
            <Divider />
            <Form form={form}>
              {models.map((model, index) => {
                // 是分组
                if (model.groupKey) {
                  if (!model.models) {
                    return <></>;
                  }
                  return (
                    <Collapse
                      key={index}
                      style={{
                        marginBottom: 24,
                      }}
                      items={[
                        {
                          key: index,
                          label: model.groupName + '（分组）',
                          children: model.models.map((subModel, iundex) => {
                            return (
                              <Form.Item
                                key={index}
                                label={subModel.fieldName}
                                // @ts-ignore
                                name={[model.groupKey, subModel.fieldName]}
                                >
                                <Input placeholder={subModel.description} />
                              </Form.Item>
                            )
                          })
                        }
                      ]}
                      bordered={false}
                      defaultActiveKey={[index]}
                      />
                  )
                }

                return (
                  <Form.Item key={index} label={model.fieldName} name={model.fieldName}>
                    <Input placeholder={model.description} />
                  </Form.Item>
                )
              })}
            </Form>
            <div style={{ marginBottom: 24 }} />
            <Space size={'middle'}>
              {downloadButton}
              <Link to={`/generator/detail/${id}`}>
                <Button>查看详情</Button>
              </Link>
            </Space>
          </Col>
          <Col flex={'320px'}>
            <Image src={data.picture} />
          </Col>
        </Row>
      </Card>
    </PageContainer>
  );
};
export default GeneratorDetail;
