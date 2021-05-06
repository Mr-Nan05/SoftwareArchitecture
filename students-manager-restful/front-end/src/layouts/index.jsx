import { Link } from 'umi'
import styles from './index.css'
import { Layout, Menu, Breadcrumb } from 'antd'

const { Header, Content, Footer } = Layout

export default function BasicLayout({ children }) {
  return (
    // <div className={styles.normal}>
    //   <div className={styles.title}>
    //     <Link to="/">Home</Link>
    //     <Link to="/student">student</Link>
    //   </div>
    //   {children}
    // </div>

    // <Layout>
    //   <Header style={{ position: 'fixed', zIndex: 1, width: '100%' }}>
    //     <div className="logo" />
    //     <Menu theme="dark" mode="horizontal" defaultSelectedKeys={['2']}>
    //       <Menu.Item key="1">
    //         <Link to="/">Home</Link>
    //       </Menu.Item>
    //       <Menu.Item key="2">
    //         <Link to="/student">student</Link>
    //       </Menu.Item>
    //     </Menu>
    //   </Header>
    //   <Content
    //     className="site-layout"
    //     style={{ padding: '0 50px', marginTop: 64 }}
    //   >
    //     <Breadcrumb style={{ margin: '16px 0' }}>
    //       <Breadcrumb.Item>Home</Breadcrumb.Item>
    //       <Breadcrumb.Item>List</Breadcrumb.Item>
    //       <Breadcrumb.Item>App</Breadcrumb.Item>
    //     </Breadcrumb>
    //     <div
    //       className="site-layout-background"
    //       style={{ padding: 24, minHeight: 380 }}
    //     >
    //       Content
    //     </div>
    //   </Content>
    //   <Footer style={{ textAlign: 'center' }}>
    //     student Management ©2021 Created by Mr.Nan
    //   </Footer>
    // </Layout>

    <Layout>
      <Header style={{ position: 'fixed', zIndex: 1, width: '100%' }}>
        <div className="logo" />
        <Menu theme="dark" mode="horizontal" defaultSelectedKeys={['2']}>
          <Menu.Item key="1">
            <Link to="/">Home</Link>
          </Menu.Item>
          <Menu.Item key="2">
            <Link to="/student"> List </Link>
          </Menu.Item>
          <Menu.Item key="3">
            <Link to="/student/3">student</Link>
          </Menu.Item>
        </Menu>
      </Header>
      <Content
        className="site-layout"
        style={{ padding: '0 50px', marginTop: 64 }}
      >
        {/* <Breadcrumb style={{ margin: '16px 0' }}>
          <Breadcrumb.Item>Home</Breadcrumb.Item>
          <Breadcrumb.Item>List</Breadcrumb.Item>
          <Breadcrumb.Item>App</Breadcrumb.Item>
        </Breadcrumb> */}

        <div
          className={styles.site_layout_background}
          style={{ padding: 24, minHeight: 380 }}
        >
          {children}
        </div>
      </Content>
      <Footer style={{ textAlign: 'center' }}>
        student Management ©2021 Created by Mr.Nan
      </Footer>
    </Layout>
  )
}
