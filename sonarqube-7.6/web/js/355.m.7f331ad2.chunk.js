(window.webpackJsonp=window.webpackJsonp||[]).push([[355],{1569:function(e,t,n){"use strict";n.r(t),n.d(t,"default",function(){return m});var a=n(352),s=n(365),l=n(366),i=n(354),r=n(0),o=n(714),c=n(552);class m extends a.PureComponent{constructor(e){super(e),this.mounted=!1,this.keepLineBreaks=(e=>{if(e.includes("\n")){const t=e.split("\n");return a.createElement(a.Fragment,null,t.map((e,n)=>a.createElement(a.Fragment,{key:n},e,n<t.length-1&&a.createElement("br",null))))}return e}),this.state={loading:!e.warnings,warnings:e.warnings||[]}}componentDidMount(){this.mounted=!0,!this.props.warnings&&this.props.taskId&&this.loadWarnings(this.props.taskId)}componentDidUpdate(e){const t=this.props,n=t.taskId,a=t.warnings;!a&&n&&e.taskId!==n?this.loadWarnings(n):a&&e.warnings!==a&&this.setState({warnings:a})}componentWillUnmount(){this.mounted=!1}loadWarnings(e){this.setState({loading:!0}),Object(c.f)(e,["warnings"]).then(({warnings:e=[]})=>{this.mounted&&this.setState({loading:!1,warnings:e})},()=>{this.mounted&&this.setState({loading:!1})})}render(){const e=Object(r.l)("warnings");return a.createElement(l.a,{contentLabel:e,onRequestClose:this.props.onClose},a.createElement("header",{className:"modal-head"},a.createElement("h2",null,e)),a.createElement("div",{className:"modal-body modal-container js-analysis-warnings"},a.createElement(s.a,{loading:this.state.loading},this.state.warnings.map((e,t)=>a.createElement("div",{className:"panel panel-vertical",key:t},a.createElement(o.a,{className:"pull-left spacer-right"}),a.createElement("div",{className:"overflow-hidden markdown"},this.keepLineBreaks(e)))))),a.createElement("footer",{className:"modal-foot"},a.createElement(i.e,{className:"js-modal-close",onClick:this.props.onClose},Object(r.l)("close"))))}}},714:function(e,t,n){"use strict";n.d(t,"a",function(){return i});var a=n(352),s=n(357),l=n(359);function i({className:e,fill:t=l.warningIconColor,size:n}){return a.createElement(s.a,{className:e,size:n},a.createElement("path",{d:"M9 12.242v-1.484c0-.14-.11-.258-.25-.258h-1.5c-.14 0-.25.117-.25.258v1.484c0 .14.11.258.25.258h1.5c.14 0 .25-.117.25-.258zM8.984 9.32l.141-3.586a.189.189 0 0 0-.078-.148C9 5.546 8.93 5.5 8.859 5.5H7.141c-.07 0-.141.047-.188.086-.055.039-.078.117-.078.164l.133 3.57c0 .102.117.18.265.18H8.72c.14 0 .258-.078.265-.18zm-.109-7.297l6 11A1 1 0 0 1 14 14.5H2a1 1 0 0 1-.875-1.477l6-11a.994.994 0 0 1 1.75 0z",style:{fill:t}}))}}}]);
//# sourceMappingURL=355.m.7f331ad2.chunk.js.map